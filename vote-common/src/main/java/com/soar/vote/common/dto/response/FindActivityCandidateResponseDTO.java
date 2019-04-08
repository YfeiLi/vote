package com.soar.vote.common.dto.response;

import lombok.ToString;

/**
 * <strong>查询活动候选人</strong>
 * date: 6/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindActivityCandidateResponseDTO {

    /** 候选人代号 */
    private String candidateCode;

    /** 候选人编号 */
    private String candidateId;

    /** 候选人姓名 */
    private String candidateName;

    /** 照片 */
    private String photoUrl;

    /** 票数 */
    private String votes;

    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
