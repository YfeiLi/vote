package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "activity_voter")
public class ActivityVoter {
    /**
     * 活动投票人编号
     */
    @Id
    @Column(name = "activity_voter_id")
    private String activityVoterId;

    /**
     * 活动编号
     */
    @Column(name = "activity_id")
    private String activityId;

    /**
     * 投票人编号
     */
    @Column(name = "voter_id")
    private String voterId;

    /**
     * 剩余票数
     */
    @Column(name = "rest_votes")
    private Short restVotes;

    /**
     * 优惠券编号
     */
    @Column(name = "coupon_id")
    private String couponId;

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
     * 获取活动投票人编号
     *
     * @return activity_voter_id - 活动投票人编号
     */
    public String getActivityVoterId() {
        return activityVoterId;
    }

    /**
     * 设置活动投票人编号
     *
     * @param activityVoterId 活动投票人编号
     */
    public void setActivityVoterId(String activityVoterId) {
        this.activityVoterId = activityVoterId;
    }

    /**
     * 获取活动编号
     *
     * @return activity_id - 活动编号
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * 设置活动编号
     *
     * @param activityId 活动编号
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
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
     * 获取剩余票数
     *
     * @return rest_votes - 剩余票数
     */
    public Short getRestVotes() {
        return restVotes;
    }

    /**
     * 设置剩余票数
     *
     * @param restVotes 剩余票数
     */
    public void setRestVotes(Short restVotes) {
        this.restVotes = restVotes;
    }

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