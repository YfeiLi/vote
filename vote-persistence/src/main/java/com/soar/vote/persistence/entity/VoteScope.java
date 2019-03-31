package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vote_scope")
public class VoteScope {
    /**
     * 区域编号
     */
    @Id
    @Column(name = "scope_id")
    private String scopeId;

    /**
     * 区域名称
     */
    @Column(name = "scope_name")
    private String scopeName;

    /**
     * 父区域
     */
    @Column(name = "scope_parent")
    private String scopeParent;

    /**
     * 区域等级
     */
    @Column(name = "scope_level")
    private Short scopeLevel;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取区域编号
     *
     * @return scope_id - 区域编号
     */
    public String getScopeId() {
        return scopeId;
    }

    /**
     * 设置区域编号
     *
     * @param scopeId 区域编号
     */
    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    /**
     * 获取区域名称
     *
     * @return scope_name - 区域名称
     */
    public String getScopeName() {
        return scopeName;
    }

    /**
     * 设置区域名称
     *
     * @param scopeName 区域名称
     */
    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    /**
     * 获取父区域
     *
     * @return scope_parent - 父区域
     */
    public String getScopeParent() {
        return scopeParent;
    }

    /**
     * 设置父区域
     *
     * @param scopeParent 父区域
     */
    public void setScopeParent(String scopeParent) {
        this.scopeParent = scopeParent;
    }

    /**
     * 获取区域等级
     *
     * @return scope_level - 区域等级
     */
    public Short getScopeLevel() {
        return scopeLevel;
    }

    /**
     * 设置区域等级
     *
     * @param scopeLevel 区域等级
     */
    public void setScopeLevel(Short scopeLevel) {
        this.scopeLevel = scopeLevel;
    }

    /**
     * 获取详细描述
     *
     * @return description - 详细描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置详细描述
     *
     * @param description 详细描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}