package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>添加投票区域</strong>
 * date: 2/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class AddVoteScopeRequestDTO implements Serializable {
    private static final long serialVersionUID = 8887459208450648616L;

    /** 区域名称 */
    private String scopeName;

    /** 父区域 */
    private String scopeParent;

    /** 区域等级 */
    private Short scopeLevel;

    /** 详细描述 */
    private String description;

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeParent() {
        return scopeParent;
    }

    public void setScopeParent(String scopeParent) {
        this.scopeParent = scopeParent;
    }

    public Short getScopeLevel() {
        return scopeLevel;
    }

    public void setScopeLevel(Short scopeLevel) {
        this.scopeLevel = scopeLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
