package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "voter_session")
public class VoterSession {
    /**
     * 令牌主体
     */
    @Id
    @Column(name = "session_content")
    private String sessionContent;

    /**
     * 投票人编号
     */
    @Column(name = "voter_id")
    private String voterId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 失效时间
     */
    @Column(name = "expired_time")
    private Date expiredTime;

    /**
     * 获取令牌主体
     *
     * @return session_content - 令牌主体
     */
    public String getSessionContent() {
        return sessionContent;
    }

    /**
     * 设置令牌主体
     *
     * @param sessionContent 令牌主体
     */
    public void setSessionContent(String sessionContent) {
        this.sessionContent = sessionContent;
    }

    /**
     * 获取投票人编号
     *
     * @return voter_id - 投票人编号
     */
    public String getVoterId() {
        return voterId;
    }

    /**
     * 设置投票人编号
     *
     * @param voterId 投票人编号
     */
    public void setVoterId(String voterId) {
        this.voterId = voterId;
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
     * 获取失效时间
     *
     * @return expired_time - 失效时间
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * 设置失效时间
     *
     * @param expiredTime 失效时间
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}