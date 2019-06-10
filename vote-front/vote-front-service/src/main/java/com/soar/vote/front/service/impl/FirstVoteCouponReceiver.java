package com.soar.vote.front.service.impl;

import com.soar.vote.common.enums.CouponScenceEnum;
import com.soar.vote.front.service.BaseCouponReceiver;
import com.soar.vote.persistence.entity.Coupon;
import com.soar.vote.persistence.entity.VoteRecord;
import com.soar.vote.persistence.mapper.CouponMapper;
import com.soar.vote.persistence.mapper.VoteRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <strong>首次投票领取优惠券</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service("firstVoteCouponReceiver")
public class FirstVoteCouponReceiver extends BaseCouponReceiver {

    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Override
    protected CouponScenceEnum getCouponScence() {
        return CouponScenceEnum.FIRSET_VOTE;
    }

    @Override
    protected String limit(String voteId) {

        // 查看是否投过票
        VoteRecord voteRecordSelectParams = new VoteRecord();
        voteRecordSelectParams.setVoterId(voteId);
        int voteRecordCount = voteRecordMapper.selectCount(voteRecordSelectParams);
        if(voteRecordCount < 1){
            return "用户未投票";
        }

        // 查看是否已领取该优惠券
        Coupon couponSelectParams = new Coupon();
        couponSelectParams.setVoterId(voteId);
        int couponCount = couponMapper.selectCount(couponSelectParams);
        if(couponCount > 0){
            return "用户已领取过优惠券";
        }

        return null;
    }
}
