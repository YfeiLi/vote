package com.soar.vote.common.dto.request;

import com.soar.vote.common.dto.base.PageRequestDTO;
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
public class FindCandidateRequestDTO extends PageRequestDTO implements Serializable {
    private static final long serialVersionUID = 7844403964131258994L;

    /** 候选人名称 */
    private String candidateName;

    /** 区域编号 */
    private String scopeId;

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
}
