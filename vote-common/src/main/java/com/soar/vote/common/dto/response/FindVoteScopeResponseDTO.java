package com.soar.vote.common.dto.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>查询投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindVoteScopeResponseDTO implements Serializable {
    private static final long serialVersionUID = 8109295536481628675L;

    /** 区域编号 */
    private String scopeId;

    /** 区域名称 */
    private String scopeName;

    /** 父区域名称 */
    private String scopeParentName;

    /** 区域等级 */
    private String scopeLevel;

    /** 详细描述 */
    private String description;

    /** 创建时间 */
    private Date createTime;

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeParentName() {
        return scopeParentName;
    }

    public void setScopeParentName(String scopeParentName) {
        this.scopeParentName = scopeParentName;
    }

    public String getScopeLevel() {
        return scopeLevel;
    }

    public void setScopeLevel(String scopeLevel) {
        this.scopeLevel = scopeLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
