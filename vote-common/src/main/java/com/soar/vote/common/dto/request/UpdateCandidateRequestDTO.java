package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>修改候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class UpdateCandidateRequestDTO implements Serializable {
    private static final long serialVersionUID = 3153048792934982404L;

    /** 候选人姓名 */
    private String candidateName;

    /** 照片 */
    private String photo;

    /** 详细描述 */
    private String description;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
