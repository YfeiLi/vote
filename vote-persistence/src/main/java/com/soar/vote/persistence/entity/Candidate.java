package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "candidate")
public class Candidate {
    /**
     * 候选者编号
     */
    @Id
    @Column(name = "candidate_id")
    private String candidateId;

    /**
     * 候选者姓名
     */
    @Column(name = "candidate_name")
    private String candidateName;

    /**
     * 区域编号
     */
    @Column(name = "scope_id")
    private String scopeId;

    /**
     * 照片路径
     */
    @Column(name = "photo_url")
    private String photoUrl;

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
     * 获取候选者编号
     *
     * @return candidate_id - 候选者编号
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * 设置候选者编号
     *
     * @param candidateId 候选者编号
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * 获取候选者姓名
     *
     * @return candidate_name - 候选者姓名
     */
    public String getCandidateName() {
        return candidateName;
    }

    /**
     * 设置候选者姓名
     *
     * @param candidateName 候选者姓名
     */
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

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
     * 获取照片路径
     *
     * @return photo_url - 照片路径
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置照片路径
     *
     * @param photoUrl 照片路径
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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