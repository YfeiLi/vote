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