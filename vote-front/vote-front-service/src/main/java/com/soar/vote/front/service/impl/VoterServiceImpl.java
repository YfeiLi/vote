package com.soar.vote.front.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soar.vote.common.dto.request.ReceiveCouponResponseDTO;
import com.soar.vote.common.dto.request.VoteRequestDTO;
import com.soar.vote.common.dto.request.VoterLoginRequestDTO;
import com.soar.vote.common.dto.response.VoteResponseDTO;
import com.soar.vote.common.dto.response.VoterLoginResponseDTO;
import com.soar.vote.common.util.HttpUtil;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.front.service.BaseCouponReceiver;
import com.soar.vote.front.service.VoterService;
import com.soar.vote.persistence.entity.*;
import com.soar.vote.persistence.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>投票人</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
@Slf4j
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterMapper voterMapper;

    @Autowired
    private VoterSessionMapper voterSessionMapper;

    @Autowired
    private ActivityVoterMapper activityVoterMapper;

    @Autowired
    private VoteActivityMapper voteActivityMapper;

    @Autowired
    private ActivityCandidateMapper activityCandidateMapper;

    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Resource(name = "firstVoteCouponReceiver")
     private BaseCouponReceiver firstVoteCouponReceiver;

    @Override
    public VoterLoginResponseDTO login(VoterLoginRequestDTO requestDTO) {

        VoterLoginResponseDTO responseDTO = new VoterLoginResponseDTO();
        Date current = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.HOUR,2);
        Date expiredTime = calendar.getTime();
        responseDTO.setExpiredTime(expiredTime);

        // 调用微信登录接口
        Map<String,String> wxResult = wxLogin(requestDTO.getJsCode());
        if(wxResult == null){
            return null;
        }
        String openId = wxResult.get("openid");
        String sessionKey = wxResult.get("session_key");
        responseDTO.setSession(sessionKey);

        // 查询登录令牌
        VoterSession sessionSelectResult = voterSessionMapper.selectByPrimaryKey(sessionKey);
        if(sessionSelectResult != null){
            // 已存在则修改有效期
            sessionSelectResult.setExpiredTime(expiredTime);
            voterSessionMapper.updateByPrimaryKeySelective(sessionSelectResult);
            responseDTO.setOldUser(true);
            return responseDTO;
        }

        // 查询投票人
        Voter voterSelectParams = new Voter();
        voterSelectParams.setWecharOpenId(openId);
        Voter voter = voterMapper.selectOne(voterSelectParams);
        if(voter != null){
            if(StringUtils.isEmpty(voter.getWecharNickname())){
                responseDTO.setOldUser(false);
            } else{
                responseDTO.setOldUser(true);
            }
        } else{
            // 不存在则创建
            responseDTO.setOldUser(false);
            voter = new Voter();
            voter.setVoterId(UUIDUtil.getUUID());
            voter.setWecharOpenId(openId);
            voter.setCreateTime(current);
            voterMapper.insertSelective(voter);
        }

        // 保存登录令牌
        VoterSession sessionInsertParams = new VoterSession();
        sessionInsertParams.setSessionContent(sessionKey);
        sessionInsertParams.setVoterId(voter.getVoterId());
        sessionInsertParams.setCreateTime(current);
        sessionInsertParams.setExpiredTime(expiredTime);
        voterSessionMapper.insertSelective(sessionInsertParams);

        // 返回
        return responseDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public VoteResponseDTO vote(VoteRequestDTO requestDTO) {

        VoteResponseDTO responseDTO = new VoteResponseDTO();

        // 校验登录令牌
        VoterSession voterSession = voterSessionMapper.selectByContent(requestDTO.getSession());
        if(voterSession == null){
            responseDTO.setErrorMsg("登录令牌已失效，请重新打开小程序");
            return responseDTO;
        }
        String voterId = voterSession.getVoterId();

        // 查询活动
        VoteActivity activity = voteActivityMapper.selectByPrimaryKey(requestDTO.getActivityId());

        // 判断活动是否在正在进行
        if(System.currentTimeMillis()<activity.getStartTime().getTime()){
            responseDTO.setErrorMsg("活动未开始");
            return responseDTO;
        }
        if((System.currentTimeMillis()-1000*60*60*24)>activity.getEndTime().getTime()){
            responseDTO.setErrorMsg("活动已结束");
            return responseDTO;
        }

        // 判断投票人是否投过票
        ActivityVoter activityVoterSelectParams = new ActivityVoter();
        activityVoterSelectParams.setVoterId(voterId);
        activityVoterSelectParams.setActivityId(requestDTO.getActivityId());
        ActivityVoter activityVoter = activityVoterMapper.selectOne(activityVoterSelectParams);
        if(activityVoter == null){
            // 添加投票人活动记录
            activityVoter = new ActivityVoter();
            activityVoter.setActivityVoterId(UUIDUtil.getUUID());
            activityVoter.setActivityId(requestDTO.getActivityId());
            activityVoter.setVoterId(voterId);
            activityVoter.setRestVotes((short)(activity.getMaxVotes()-1));
            activityVoter.setCreateTime(new Date());
            activityVoterMapper.insertSelective(activityVoter);

            // 赠送优惠券
            responseDTO.setCouponId(String.valueOf(System.currentTimeMillis()));
        } else{
            // 判断投票人是否有剩余票数
            if(activityVoter.getRestVotes() <= 0){
                responseDTO.setErrorMsg("没有剩余票数");
                return responseDTO;
            }

            // 修改投票人剩余票数
            activityVoter.setRestVotes((short)(activityVoter.getRestVotes()-1));
            activityVoter.setUpdateTime(new Date());
            activityVoterMapper.updateByPrimaryKeySelective(activityVoter);
        }

        // 查询候选人得票
        ActivityCandidate activityCandidate = new ActivityCandidate();
        activityCandidate.setActivityId(requestDTO.getActivityId());
        activityCandidate.setCandidateId(requestDTO.getCandidateId());
        activityCandidate = activityCandidateMapper.selectOne(activityCandidate);

        // 修改候选人得票数
        activityCandidate.setVotes((short)(activityCandidate.getVotes()+1));
        activityCandidate.setUpdateTime(new Date());
        activityCandidateMapper.updateByPrimaryKeySelective(activityCandidate);

        // 添加投票记录
        VoteRecord voteRecord = new VoteRecord();
        voteRecord.setRecordId(UUIDUtil.getUUID());
        voteRecord.setActivityId(requestDTO.getActivityId());
        voteRecord.setCandidateId(requestDTO.getCandidateId());
        voteRecord.setVoterId(voterId);
        voteRecord.setCreatTime(new Date());
        voteRecord.setUpdateTime(new Date());
        voteRecordMapper.insertSelective(voteRecord);

        // 领取优惠券
        ReceiveCouponResponseDTO receiveCouponResponseDTO;
        try{
            receiveCouponResponseDTO = firstVoteCouponReceiver.handle(voterId);
            if(receiveCouponResponseDTO.getSuccess()){
                responseDTO.setCouponId(receiveCouponResponseDTO.getCouponId());
            }
        } catch (Exception e){
            log.error("领取优惠券未知异常",e);
        }

        // 返回成功
        return responseDTO;
    }

    /**
     * 微信登录接口
     * @author liyifei
     * @date 7/4/2019
     * @param jsCode js登录码
     * @return 微信登录结果
     */
    private Map<String,String> wxLogin(String jsCode) {

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String appId = "wx659151a06c529cec";
        String secret = "9504c5f5fb6dcbe7d23422c58ffe85ef";
        String grantType = "authorization_code";

        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("appid",appId);
        reqMap.put("secret",secret);
        reqMap.put("js_code",jsCode);
        reqMap.put("grant_type",grantType);
        Map<String,Object> resultMap = HttpUtil.httpClientRequest(url,reqMap);
        if(!(boolean) resultMap.get("success")){
            log.error("微信接口调用失败："+new JSONObject(resultMap));
            return null;
        }

        String data = (String) resultMap.get("data");
        JSONObject jsonData = JSONObject.parseObject(data);
        if(StringUtils.isEmpty(jsonData.get("openid"))||StringUtils.isEmpty(jsonData.get("session_key"))){
            log.error("微信接口返回数据异常："+data);
            return null;
        }
        Map<String,String> wxResult = new HashMap<>();
        wxResult.put("openid",(String) jsonData.get("openid"));
        wxResult.put("session_key",(String)jsonData.get("session_key"));
        return wxResult;
    }
}
