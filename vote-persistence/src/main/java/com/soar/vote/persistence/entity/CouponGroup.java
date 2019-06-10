package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "coupon_group")
public class CouponGroup {
    /**
     * 优惠券组编号
     */
    @Id
    @Column(name = "coupon_group_id")
    private String couponGroupId;

    /**
     * 优惠券名称
     */
    @Column(name = "coupon_name")
    private String couponName;

    /**
     * 优惠券类型（01折扣；02抵扣）
     */
    @Column(name = "coupon_type")
    private Short couponType;

    /**
     * 折扣率（100即免费）
     */
    @Column(name = "discount_rate")
    private Integer discountRate;

    /**
     * 抵扣金额（单位：分）
     */
    @Column(name = "discount_amout")
    private Integer discountAmout;

    /**
     * 商品编号
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 区域编号
     */
    @Column(name = "scope_id")
    private String scopeId;

    /**
     * 领取场景
     */
    private Short scene;

    /**
     * 优惠券券组状态（0停用；1启用）
     */
    @Column(name = "coupon_group_status")
    private Short couponGroupStatus;

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
     * 获取优惠券名称
     *
     * @return coupon_name - 优惠券名称
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 设置优惠券名称
     *
     * @param couponName 优惠券名称
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    /**
     * 获取优惠券类型（01折扣；02抵扣）
     *
     * @return coupon_type - 优惠券类型（01折扣；02抵扣）
     */
    public Short getCouponType() {
        return couponType;
    }

    /**
     * 设置优惠券类型（01折扣；02抵扣）
     *
     * @param couponType 优惠券类型（01折扣；02抵扣）
     */
    public void setCouponType(Short couponType) {
        this.couponType = couponType;
    }

    /**
     * 获取折扣率（100即免费）
     *
     * @return discount_rate - 折扣率（100即免费）
     */
    public Integer getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置折扣率（100即免费）
     *
     * @param discountRate 折扣率（100即免费）
     */
    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 获取抵扣金额（单位：分）
     *
     * @return discount_amout - 抵扣金额（单位：分）
     */
    public Integer getDiscountAmout() {
        return discountAmout;
    }

    /**
     * 设置抵扣金额（单位：分）
     *
     * @param discountAmout 抵扣金额（单位：分）
     */
    public void setDiscountAmout(Integer discountAmout) {
        this.discountAmout = discountAmout;
    }

    /**
     * 获取商品编号
     *
     * @return goods_id - 商品编号
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品编号
     *
     * @param goodsId 商品编号
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取区域编号
     *
     * @return scope_id - 区域编号
     */
    public String getScopeId() {
        return scopeId;
    }

    /**
     * 设置区域编号
     *
     * @param scopeId 区域编号
     */
    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    /**
     * 获取领取场景
     *
     * @return scene - 领取场景
     */
    public Short getScene() {
        return scene;
    }

    /**
     * 设置领取场景
     *
     * @param scene 领取场景
     */
    public void setScene(Short scene) {
        this.scene = scene;
    }

    /**
     * 获取优惠券券组状态（0停用；1启用）
     *
     * @return coupon_group_status - 优惠券券组状态（0停用；1启用）
     */
    public Short getCouponGroupStatus() {
        return couponGroupStatus;
    }

    /**
     * 设置优惠券券组状态（0停用；1启用）
     *
     * @param couponGroupStatus 优惠券券组状态（0停用；1启用）
     */
    public void setCouponGroupStatus(Short couponGroupStatus) {
        this.couponGroupStatus = couponGroupStatus;
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