package com.soar.vote.common.dto.response;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>投票人登录</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class VoterLoginResponseDTO implements Serializable {
    private static final long serialVersionUID = -284028731799156089L;

    /** 登录令牌 */
    private String session;

    /** 是否旧用户 */
    private Boolean oldUser;

    /** 过期时间 */
    private Date expiredTime;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Boolean getOldUser() {
        return oldUser;
    }

    public void setOldUser(Boolean oldUser) {
        this.oldUser = oldUser;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}
