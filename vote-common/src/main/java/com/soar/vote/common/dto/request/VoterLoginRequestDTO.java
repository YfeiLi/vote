package com.soar.vote.common.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * <strong>投票人登录</strong>
 * date: 9/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class VoterLoginRequestDTO implements Serializable {
    private static final long serialVersionUID = -8421317337588835004L;

    /** js登录码 */
    private String jsCode;

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }
}
