package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon")
public class Coupon {
    /**
     * 优惠券编号
     */
    @Id
    @Column(name = "coupon_id")
    private String couponId;

    /**
     * 投票人编号
     */
    @Column(name = "voter_id")
    private String voterId;

    /**
     * 优惠券组编号
     */
    @Column(name = "coupon_group_id")
    private String couponGroupId;

    /**
     * 优惠券状态（0未使用；1已使用；2已禁用；3已过期）
     */
    @Column(name = "coupon_status")
    private Short couponStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取优惠券编号
     *
     * @return coupon_id - 优惠券编号
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 设置优惠券编号
     *
     * @param couponId 优惠券编号
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取投票人编号
     *
     * @return voter_id - 投票人编号
     */
    public String getVoterId() {
        return voterId;
    }

    /**
     * 设置投票人编号
     *
     * @param voterId 投票人编号
     */
    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    /**
     * 获取优惠券组编号
     *
     * @return coupon_group_id - 优惠券组编号
     */
    public String getCouponGroupId() {
        return couponGroupId;
    }

    /**
     * 设置优惠券组编号
     *
     * @param couponGroupId 优惠券组编号
     */
    public void setCouponGroupId(String couponGroupId) {
        this.couponGroupId = couponGroupId;
    }

    /**
     * 获取优惠券状态（0未使用；1已使用；2已禁用；3已过期）
     *
     * @return coupon_status - 优惠券状态（0未使用；1已使用；2已禁用；3已过期）
     */
    public Short getCouponStatus() {
        return couponStatus;
    }

    /**
     * 设置优惠券状态（0未使用；1已使用；2已禁用；3已过期）
     *
     * @param couponStatus 优惠券状态（0未使用；1已使用；2已禁用；3已过期）
     */
    public void setCouponStatus(Short couponStatus) {
        this.couponStatus = couponStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}