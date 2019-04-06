package com.soar.vote.common.dto.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>查询投票活动</strong>
 * date: 5/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindVoteActivityResponseDTO implements Serializable {
    private static final long serialVersionUID = -8333046384792862346L;

    /** 活动编号 */
    private String activityId;

    /** 活动名称 */
    private String activityName;

    /** 区域名称 */
    private String scopeName;

    /** 候选人数量 */
    private Integer candidateNum;

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

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public Integer getCandidateNum() {
        return candidateNum;
    }

    public void setCandidateNum(Integer candidateNum) {
        this.candidateNum = candidateNum;
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
