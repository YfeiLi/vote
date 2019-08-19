package com.soar.vote.front.service;

import com.soar.vote.common.dto.request.VoteRequestDTO;
import com.soar.vote.common.dto.request.VoterLoginRequestDTO;
import com.soar.vote.common.dto.response.VoteResponseDTO;
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
     * @since 7/4/2019
     * @param requestDTO 登录参数
     * @return 登录令牌
     */
    VoterLoginResponseDTO login(VoterLoginRequestDTO requestDTO) ;

    /**
     * 投票
     * @author liyifei
     * @since 7/4/2019
     * @return 错误信息
     */
    VoteResponseDTO vote(VoteRequestDTO requestDTO) ;
}
