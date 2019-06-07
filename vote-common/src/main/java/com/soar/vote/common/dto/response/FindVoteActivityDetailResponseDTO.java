package com.soar.vote.common.dto.response;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>查询投票活动详情</strong>
 * date: 7/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class FindVoteActivityDetailResponseDTO implements Serializable {
    private static final long serialVersionUID = 8485933290496435034L;

    /** 活动编号 */
    private String activityId;

    /** 活动名称 */
    private String activityName;

    /** 区域编号 */
    private String scopeId;

    /** 投票数限制类型 */
    private Short votesLimitType;

    /** 投票人最大投票数（1每天；2整个活动） */
    private Short maxVotes;

    /** 详细描述 */
    private String description;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public Short getVotesLimitType() {
        return votesLimitType;
    }

    public void setVotesLimitType(Short votesLimitType) {
        this.votesLimitType = votesLimitType;
    }

    public Short getMaxVotes() {
        return maxVotes;
    }

    public void setMaxVotes(Short maxVotes) {
        this.maxVotes = maxVotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
