package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>新增候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class AddCandidateRequestDTO implements Serializable {
    private static final long serialVersionUID = 4892101432925979988L;

    /** 候选人姓名 */
    private String candidateName;

    /** 区域编号 */
    private String scopeId;

    /** 照片（base64字符串） */
    private String photo;

    /** 详细描述 */
    private String description;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
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
