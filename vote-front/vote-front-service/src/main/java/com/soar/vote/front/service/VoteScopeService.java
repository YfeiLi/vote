package com.soar.vote.front.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;

/**
 * <strong>投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface VoteScopeService {

    /**
     * 查询投票区域列表
     * @author liyifei
     * @date 31/3/2019
     * @param requestDTO 查询条件
     * @return 区域列表
     */
    PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO) throws Exception;
}
