package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.persistence.entity.Candidate;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CandidateMapper extends Mapper<Candidate> {

    /**
     * 查询候选人列表
     * @author liyifei
     * @date 3/4/2019
     * @param requestDTO 查询条件
     * @return 候选人列表
     */
    List<FindCandidateResponseDTO> find(FindCandidateRequestDTO requestDTO);
}