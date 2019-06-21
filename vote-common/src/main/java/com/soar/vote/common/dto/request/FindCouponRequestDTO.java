package com.soar.vote.common.dto.request;

import com.soar.vote.common.dto.base.PageRequestDTO;

import java.io.Serializable;

/**
 * <strong>查询优惠券</strong>
 * date: 9/6/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class FindCouponRequestDTO extends PageRequestDTO implements Serializable {
    private static final long serialVersionUID = -8027612220450340647L;

    /** 登录标识 */
    private String session;

    /** 区域编号 */
    private String scopeId;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }
}
