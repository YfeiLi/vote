package com.soar.vote.common.dto.response;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>功能描述</strong>
 * date: 12/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class VoteResponseDTO implements Serializable {
    private static final long serialVersionUID = -8232857968975730450L;

    /** 优惠券编号（不为空则中奖） */
    private String couponId;

    /** 错误信息 */
    private String errorMsg;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
