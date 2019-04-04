package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.persistence.entity.VoteActivity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VoteActivityMapper extends Mapper<VoteActivity> {

    /**
     * 查询投票活动列表
     * @author liyifei
     * @date 5/4/2019
     * @param requestDTO 查询条件
     * @return 活动列表
     */
    List<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO);
}