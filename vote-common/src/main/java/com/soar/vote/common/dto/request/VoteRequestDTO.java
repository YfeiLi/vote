package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>投票</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class VoteRequestDTO implements Serializable {
    private static final long serialVersionUID = -3771898229002840689L;

    /** 登录令牌 */
    private String session;

    /** 活动编号 */
    private String activityId;

    /** 候选人编号 */
    private String candidateId;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
}
