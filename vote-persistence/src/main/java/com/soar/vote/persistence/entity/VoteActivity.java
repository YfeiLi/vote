package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vote_activity")
public class VoteActivity {
    /**
     * 活动编号
     */
    @Id
    @Column(name = "activity_id")
    private String activityId;

    /**
     * 活动名称
     */
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 区域编号
     */
    @Column(name = "scope_id")
    private String scopeId;

    /**
     * 投票数限制类型
     */
    @Column(name = "votes_limit_type")
    private Short votesLimitType;

    /**
     * 投票人最大投票数（1每天；2整个活动）
     */
    @Column(name = "max_votes")
    private Short maxVotes;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

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
     * 获取活动名称
     *
     * @return activity_name - 活动名称
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName 活动名称
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
     * 获取投票数限制类型
     *
     * @return votes_limit_type - 投票数限制类型
     */
    public Short getVotesLimitType() {
        return votesLimitType;
    }

    /**
     * 设置投票数限制类型
     *
     * @param votesLimitType 投票数限制类型
     */
    public void setVotesLimitType(Short votesLimitType) {
        this.votesLimitType = votesLimitType;
    }

    /**
     * 获取投票人最大投票数（1每天；2整个活动）
     *
     * @return max_votes - 投票人最大投票数（1每天；2整个活动）
     */
    public Short getMaxVotes() {
        return maxVotes;
    }

    /**
     * 设置投票人最大投票数（1每天；2整个活动）
     *
     * @param maxVotes 投票人最大投票数（1每天；2整个活动）
     */
    public void setMaxVotes(Short maxVotes) {
        this.maxVotes = maxVotes;
    }

    /**
     * 获取详细描述
     *
     * @return description - 详细描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置详细描述
     *
     * @param description 详细描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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