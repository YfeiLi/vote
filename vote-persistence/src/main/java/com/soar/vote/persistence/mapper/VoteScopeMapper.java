package com.soar.vote.persistence.mapper;

import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.persistence.entity.VoteScope;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VoteScopeMapper extends Mapper<VoteScope> {

    /**
     * 查询区域列表
     * @author liyifei
     * @date 31/3/2019
     * @param params 查询条件
     * @return 区域列表
     */
    List<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO params);
}