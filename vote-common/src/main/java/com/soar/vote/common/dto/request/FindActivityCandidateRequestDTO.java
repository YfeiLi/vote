package com.soar.vote.common.dto.request;

import com.soar.vote.common.dto.base.PageRequestDTO;
import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>查询活动候选人</strong>
 * date: 2/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindActivityCandidateRequestDTO extends PageRequestDTO implements Serializable {
    private static final long serialVersionUID = -8903181392521228737L;

    /** 活动编号 */
    private String activityId;

    /** 候选人姓名 */
    private String candidateName;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}
