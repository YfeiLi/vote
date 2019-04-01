package com.soar.vote.common.dto.request;

import com.soar.vote.common.dto.PageRequestDTO;
import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>查询投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindVoteScopeRequestDTO extends PageRequestDTO implements Serializable {
    private static final long serialVersionUID = -6409518488663894282L;

    /** 区域名称  */
    private String scopeName;

    /** 父区域 */
    private String scopeParent;

    /** 区域等级 */
    private Short scopeLevel;

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
}
