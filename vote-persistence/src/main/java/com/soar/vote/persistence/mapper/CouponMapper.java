package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.request.FindCouponRequestDTO;
import com.soar.vote.common.dto.response.FindCouponResponseDTO;
import com.soar.vote.persistence.entity.Coupon;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CouponMapper extends Mapper<Coupon> {

    List<FindCouponResponseDTO> find(FindCouponRequestDTO requestDTO);
}