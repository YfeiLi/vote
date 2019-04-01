package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>修改投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class UpdateVoteScopeRequestDTO implements Serializable {
    private static final long serialVersionUID = -4995443304962431273L;

    /** 区域名 */
    private String scopeName;

    /** 详细描述 */
    private String description;

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
}
