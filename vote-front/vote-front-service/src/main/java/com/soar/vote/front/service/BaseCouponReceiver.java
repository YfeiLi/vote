package com.soar.vote.front.service;

import com.soar.vote.common.dto.request.ReceiveCouponResponseDTO;
import com.soar.vote.common.enums.CouponGroupStatusEnum;
import com.soar.vote.common.enums.CouponScenceEnum;
import com.soar.vote.common.enums.CouponStatusEnum;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.persistence.entity.Coupon;
import com.soar.vote.persistence.entity.CouponGroup;
import com.soar.vote.persistence.mapper.CouponGroupMapper;
import com.soar.vote.persistence.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * <strong>领取优惠券</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public abstract class BaseCouponReceiver {

    @Autowired
    private CouponGroupMapper couponGroupMapper;

    @Autowired
    private CouponMapper couponMapper;

    /**
     * 领取优惠券
     * @author liyifei
     * @date 9/6/2019
     * @param voteId 投票人编号
     * @return 领取结果
     */
    public ReceiveCouponResponseDTO handle(String voteId){

        ReceiveCouponResponseDTO responseDTO = new ReceiveCouponResponseDTO();

        // 判断能否领取
        String errorMsg = limit(voteId);
        if(errorMsg != null){
            responseDTO.setSuccess(false);
            responseDTO.setErrorMsg(errorMsg);
            return responseDTO;
        }

        // 查询优惠券券组
        CouponGroup couponGroupSelectParams = new CouponGroup();
        couponGroupSelectParams.setScene(getCouponScence().getCode());
        couponGroupSelectParams.setCouponGroupStatus(CouponGroupStatusEnum.ENABLE.getCode());
        CouponGroup couponGroup = couponGroupMapper.selectOne(couponGroupSelectParams);
        if(couponGroup == null){
            responseDTO.setSuccess(false);
            responseDTO.setErrorMsg("无对应优惠券券组");
            return responseDTO;
        }

        // 创建优惠券
        String couponId = UUIDUtil.getHashID(20);
        Coupon coupon = new Coupon();
        coupon.setCouponId(couponId);
        coupon.setVoterId(voteId);
        coupon.setCouponGroupId(couponGroup.getCouponGroupId());
        coupon.setCouponStatus(CouponStatusEnum.UNUSED.getCode());
        coupon.setCreateTime(new Date());
        couponMapper.insertSelective(coupon);

        // 返回成功
        responseDTO.setSuccess(true);
        responseDTO.setCouponId(couponId);
        return responseDTO;
    }

    /**
     * 获取优惠券场景
     * @author liyifei
     * @date 9/6/2019
     * @return 优惠券场景
     */
    protected abstract CouponScenceEnum getCouponScence();

    /**
     * 判断用户能否领取
     * @author liyifei
     * @date 9/6/2019
     * @param voteId 投票人编号
     * @return 错误信息（null表示可以领取）
     */
    protected abstract String limit(String voteId);

    public static void main(String[] args) {
        System.out.println(UUIDUtil.getUUID());
    }
}
