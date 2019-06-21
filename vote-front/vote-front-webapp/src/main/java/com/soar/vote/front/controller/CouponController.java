package com.soar.vote.front.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCouponRequestDTO;
import com.soar.vote.common.dto.response.FindCouponResponseDTO;
import com.soar.vote.front.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <strong>优惠券</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("coupon")
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    ResponseEntity<PageInfo<FindCouponResponseDTO>> find(FindCouponRequestDTO requestDTO){

        PageInfo<FindCouponResponseDTO> page = couponService.find(requestDTO);
        return ResponseEntity.ok(page);
    }

}
