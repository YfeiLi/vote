package com.soar.vote.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCouponRequestDTO;
import com.soar.vote.common.dto.response.FindCouponResponseDTO;
import com.soar.vote.front.service.CouponService;
import com.soar.vote.persistence.mapper.CouponGroupMapper;
import com.soar.vote.persistence.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <strong>功能描述</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public PageInfo<FindCouponResponseDTO> find(FindCouponRequestDTO requestDTO) {

        PageHelper.startPage(requestDTO);

        return null;
    }
}
