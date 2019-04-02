package com.soar.vote.manager.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;

/**
 * <strong>候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface CandidateService {

    /**
     * 查询候选人列表
     * @param requestDTO 查询条件
     * @return 候选人列表
     */
    PageInfo<FindCandidateResponseDTO> find(FindCandidateRequestDTO requestDTO);
}
