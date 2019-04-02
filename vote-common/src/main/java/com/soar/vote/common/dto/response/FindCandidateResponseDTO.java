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
public class FindCandidateResponseDTO implements Serializable {
    private static final long serialVersionUID = 7091227623339792423L;

    /** 编号 */
    private String candidateId;

    /** 候选人姓名 */
    private String candidateName;

    /** 区域名称 */
    private String scopeName;

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

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
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
