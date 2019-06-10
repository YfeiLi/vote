package com.soar.vote.front.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCouponRequestDTO;
import com.soar.vote.common.dto.response.FindCouponResponseDTO;

/**
 * <strong>优惠券</strong>
 *
 * @author liyifei
 * @version 1.0
 **/
public interface CouponService {

    /**
     * 查询优惠券
     * @author liyifei
     * @date 9/6/2019
     * @param requestDTO 查询条件
     * @return 优惠券列表
     */
    PageInfo<FindCouponResponseDTO> find(FindCouponRequestDTO requestDTO);
}
