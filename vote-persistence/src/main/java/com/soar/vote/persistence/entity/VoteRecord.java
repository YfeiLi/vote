package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vote_record")
public class VoteRecord {
    /**
     * 记录编号
     */
    @Id
    @Column(name = "record_id")
    private String recordId;

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
     * 投票人编号
     */
    @Column(name = "voter_id")
    private String voterId;

    /**
     * 创建时间
     */
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取记录编号
     *
     * @return record_id - 记录编号
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * 设置记录编号
     *
     * @param recordId 记录编号
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
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
     * 获取创建时间
     *
     * @return creat_time - 创建时间
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置创建时间
     *
     * @param creatTime 创建时间
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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