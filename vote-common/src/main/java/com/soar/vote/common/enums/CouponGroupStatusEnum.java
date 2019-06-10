package com.soar.vote.common.enums;

/**
 * <strong>优惠券券组状态</strong>
 *
 * @author liyifei
 * @version 1.0
 **/
public enum CouponGroupStatusEnum {

    /** 停用 */
    DISABLE((short)0,"停用"),
    /** 启用 */
    ENABLE((short)1,"启用"),
    ;

    /** 编号 */
    private Short code;

    /** 描述 */
    private String desc;

    CouponGroupStatusEnum(Short code, String desc) {
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
