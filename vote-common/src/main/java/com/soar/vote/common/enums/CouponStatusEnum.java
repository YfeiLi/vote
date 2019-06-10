package com.soar.vote.common.enums;

/**
 * <strong>优惠券状态</strong>
 *
 * @author liyifei
 * @version 1.0
 **/
public enum CouponStatusEnum {

    /** 未使用 */
    UNUSED((short)0,"未使用"),
    /** 已使用 */
    USED((short)1,"已使用"),
    /** 已禁用 */
    DISABLE((short)2,"已禁用"),
    /** 已禁用 */
    EXPIRED((short)3,"已过期"),
    ;

    /** 编号 */
    private Short code;

    /** 描述 */
    private String desc;

    CouponStatusEnum(Short code, String desc) {
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
