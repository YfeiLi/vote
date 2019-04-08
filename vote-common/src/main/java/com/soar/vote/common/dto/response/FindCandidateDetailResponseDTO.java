package com.soar.vote.common.dto.response;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>查询候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindCandidateDetailResponseDTO implements Serializable {
    private static final long serialVersionUID = 7091227623339792423L;

    /** 编号 */
    private String candidateId;

    /** 候选人姓名 */
    private String candidateName;

    /** 照片 */
    private String photoUrl;

    /** 详细描述 */
    private String description;

    /** 创建时间 */
    private String createTime;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
