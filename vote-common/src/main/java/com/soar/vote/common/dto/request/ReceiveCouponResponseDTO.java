package com.soar.vote.common.dto.request;

import java.io.Serializable;

/**
 * <strong>优惠券领取</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class ReceiveCouponResponseDTO implements Serializable {
    private static final long serialVersionUID = 8787629764864654171L;

    /** 是否成功 */
    private Boolean success;

    /** 错误信息（success为false时不为空） */
    private String errorMsg;

    /** 优惠券编号（success为true时不为空） */
    private String couponId;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
