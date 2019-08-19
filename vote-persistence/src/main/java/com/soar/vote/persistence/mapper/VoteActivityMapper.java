package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.request.FindActivityCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindActivityCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.persistence.entity.VoteActivity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VoteActivityMapper extends Mapper<VoteActivity> {

    /**
     * 查询投票活动列表
     * @author liyifei
     * @since 5/4/2019
     * @param requestDTO 查询条件
     * @return 活动列表
     */
    List<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO);

    /**
     * 查询活动候选人
     * @author liyifei
     * @since 3/5/2019
     * @param requestDTO 查询条件
     * @return 候选人列表
     */
    List<FindActivityCandidateResponseDTO> findCandidate(FindActivityCandidateRequestDTO requestDTO);
}