package com.soar.vote.common.enums;

/**
 * <strong>优惠券领取场景</strong>
 *
 * @author liyifei
 * @version 1.0
 **/
public enum CouponScenceEnum {

    /** 第一次投票 */
    FIRSET_VOTE((short)1,"第一次投票"),
    ;

    /** 编号 */
    private Short code;
    /** 描述 */
    private String desc;

    CouponScenceEnum(Short code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
