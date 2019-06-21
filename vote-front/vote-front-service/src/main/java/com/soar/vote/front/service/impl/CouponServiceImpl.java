package com.soar.vote.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCouponRequestDTO;
import com.soar.vote.common.dto.response.FindCouponResponseDTO;
import com.soar.vote.common.dto.response.VoteResponseDTO;
import com.soar.vote.front.service.CouponService;
import com.soar.vote.persistence.entity.VoterSession;
import com.soar.vote.persistence.mapper.CouponGroupMapper;
import com.soar.vote.persistence.mapper.CouponMapper;
import com.soar.vote.persistence.mapper.VoterSessionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>功能描述</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
@Slf4j
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private VoterSessionMapper voterSessionMapper;

    @Override
    public PageInfo<FindCouponResponseDTO> find(FindCouponRequestDTO requestDTO) {

        // 校验登录令牌
        VoterSession voterSession = voterSessionMapper.selectByContent(requestDTO.getSession());
        if(voterSession == null){
            log.warn("登录令牌已失效");
            return PageInfo.of(new ArrayList<>());
        }
        String voterId = voterSession.getVoterId();

        // 查询优惠券
        PageHelper.startPage(requestDTO);
        List<FindCouponResponseDTO> list = couponMapper.find(voterId, requestDTO.getScopeId());
        return PageInfo.of(list);
    }
}
