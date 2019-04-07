package com.soar.vote.front.service;

import com.soar.vote.common.dto.response.VoterLoginResponseDTO;

/**
 * <strong>投票人</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface VoterService {

    /**
     * 投票人登录
     * @author liyifei
     * @date 7/4/2019
     * @param jsCode js登录码
     * @return 登录令牌
     */
    VoterLoginResponseDTO login(String jsCode) throws Exception;
}
