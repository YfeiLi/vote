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

    /** 投票人编号 */
    private String voterId;

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
}
