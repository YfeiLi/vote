package com.soar.vote.common.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>新增投票活动</strong>
 * date: 5/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class AddVoteActivityRequestDTO implements Serializable {
    private static final long serialVersionUID = -4640784100237352868L;

    /** 活动名称 */
    private String activityName;

    /** 区域编号 */
    private String scopeId;

    /** 投票数限制类型（1每天；2整个活动） */
    private Short votesLimitType;

    /** 最大投票数 */
    private Short maxVotes;

    /** 详细描述 */
    private String description;

    /** 开始时间 */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;

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
