package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "goods")
public class Goods {
    /**
     * 商品编号
     */
    @Id
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 图片路径
     */
    @Column(name = "phote_url")
    private String photeUrl;

    /**
     * 商品价格（单位：分）
     */
    @Column(name = "goods_price")
    private Integer goodsPrice;

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
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取图片路径
     *
     * @return phote_url - 图片路径
     */
    public String getPhoteUrl() {
        return photeUrl;
    }

    /**
     * 设置图片路径
     *
     * @param photeUrl 图片路径
     */
    public void setPhoteUrl(String photeUrl) {
        this.photeUrl = photeUrl;
    }

    /**
     * 获取商品价格（单位：分）
     *
     * @return goods_price - 商品价格（单位：分）
     */
    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 设置商品价格（单位：分）
     *
     * @param goodsPrice 商品价格（单位：分）
     */
    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
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