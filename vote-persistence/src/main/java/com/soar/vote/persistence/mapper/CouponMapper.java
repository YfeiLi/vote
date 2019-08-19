package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.response.FindCouponResponseDTO;
import com.soar.vote.persistence.entity.Coupon;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CouponMapper extends Mapper<Coupon> {

    /**
     * 查询投票人优惠券
     * @author liyifei
     * @since 21/6/2019
     * @param voterId 投票人编号
     * @param scopeId 区域编号
     * @return
     */
    List<FindCouponResponseDTO> find(String voterId, String scopeId);
}