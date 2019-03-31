package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vote_statistics")
public class VoteStatistics {
    /**
     * 统计编号
     */
    @Id
    @Column(name = "statistics_id")
    private String statisticsId;

    /**
     * 活动编号
     */
    @Column(name = "activity_id")
    private String activityId;

    /**
     * 候选人编号
     */
    @Column(name = "candidate_id")
    private String candidateId;

    /**
     * 投票数
     */
    @Column(name = "vote_count")
    private Integer voteCount;

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
     * 获取统计编号
     *
     * @return statistics_id - 统计编号
     */
    public String getStatisticsId() {
        return statisticsId;
    }

    /**
     * 设置统计编号
     *
     * @param statisticsId 统计编号
     */
    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
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
     * 获取候选人编号
     *
     * @return candidate_id - 候选人编号
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * 设置候选人编号
     *
     * @param candidateId 候选人编号
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * 获取投票数
     *
     * @return vote_count - 投票数
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * 设置投票数
     *
     * @param voteCount 投票数
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
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