package com.soar.vote.manager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soar.vote.common.dto.request.VoteRequestDTO;
import com.soar.vote.common.dto.request.VoterLoginRequestDTO;
import com.soar.vote.common.dto.response.VoterLoginResponseDTO;
import com.soar.vote.common.util.HttpUtil;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.manager.service.VoterService;
import com.soar.vote.persistence.entity.ActivityVoter;
import com.soar.vote.persistence.entity.VoteActivity;
import com.soar.vote.persistence.entity.Voter;
import com.soar.vote.persistence.entity.VoterSession;
import com.soar.vote.persistence.mapper.ActivityVoterMapper;
import com.soar.vote.persistence.mapper.VoteActivityMapper;
import com.soar.vote.persistence.mapper.VoterMapper;
import com.soar.vote.persistence.mapper.VoterSessionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public VoterLoginResponseDTO login(VoterLoginRequestDTO requestDTO) throws Exception {

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
            throw new RuntimeException("调用微信登录接口失败");
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
            responseDTO.setOldUser(true);
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
    public String vote(VoteRequestDTO requestDTO) throws Exception {

        // 校验登录令牌
        VoterSession voterSession = voterSessionMapper.selectByContent(requestDTO.getSession());
        if(voterSession == null){
            return "登录令牌已失效";
        }
        String voterId = voterSession.getVoterId();

        // 判断投票人是否投过票
        ActivityVoter activityVoterSelectParams = new ActivityVoter();
        activityVoterSelectParams.setVoterId(voterId);
        activityVoterSelectParams.setActivityId(requestDTO.getActivityId());
        ActivityVoter activityVoterSelectResult = activityVoterMapper.selectOne(activityVoterSelectParams);
        if(activityVoterSelectResult == null){
            // 查询活动最大投票数
            VoteActivity activity = voteActivityMapper.selectByPrimaryKey(requestDTO.getActivityId());

            // 添加投票人投票记录

        }

        // 判断投票人是否有剩余票数

        // 修改候选人得票/投票人剩余票数

        // 返回成功
        return null;
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
        String appId = "wx60924f734f50190c";
        String secret = "1267c802ffedc5dcf30c6a2311af433d";
        String grantType = "authorization_code";

        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("appid",appId);
        reqMap.put("secret",secret);
        reqMap.put("js_code",jsCode);
        reqMap.put("grant_type",grantType);
        Map<String,Object> resultMap = HttpUtil.httpClientRequest(url,reqMap);
        if(!(boolean) resultMap.get("success")){
            log.error((String) resultMap.get("msg"));
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
