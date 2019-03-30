package com.soar.vote.persistence.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "voter")
public class Voter {
    /**
     * 投票人编号
     */
    @Id
    @Column(name = "voter_id")
    private String voterId;

    /**
     * 投票人微信昵称
     */
    @Column(name = "wechar_nickname")
    private String wecharNickname;

    /**
     * 投票人手机号
     */
    @Column(name = "voter_mobile")
    private String voterMobile;

    /**
     * 投票人姓名
     */
    @Column(name = "voter_name")
    private String voterName;

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
     * 获取投票人微信昵称
     *
     * @return wechar_nickname - 投票人微信昵称
     */
    public String getWecharNickname() {
        return wecharNickname;
    }

    /**
     * 设置投票人微信昵称
     *
     * @param wecharNickname 投票人微信昵称
     */
    public void setWecharNickname(String wecharNickname) {
        this.wecharNickname = wecharNickname;
    }

    /**
     * 获取投票人手机号
     *
     * @return voter_mobile - 投票人手机号
     */
    public String getVoterMobile() {
        return voterMobile;
    }

    /**
     * 设置投票人手机号
     *
     * @param voterMobile 投票人手机号
     */
    public void setVoterMobile(String voterMobile) {
        this.voterMobile = voterMobile;
    }

    /**
     * 获取投票人姓名
     *
     * @return voter_name - 投票人姓名
     */
    public String getVoterName() {
        return voterName;
    }

    /**
     * 设置投票人姓名
     *
     * @param voterName 投票人姓名
     */
    public void setVoterName(String voterName) {
        this.voterName = voterName;
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