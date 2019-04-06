package com.soar.vote.manager.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteActivityRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;

/**
 * <strong>投票活动</strong>
 * date: 5/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface VoteActivityService {

    /**
     * 添加投票活动
     * @author liyifei
     * @date 5/4/2019
     * @param requestDTO
     * @return 活动编号
     */
    String add(AddVoteActivityRequestDTO requestDTO);

    /**
     * 查询投票活动列表
     * @author liyifei
     * @date 5/4/2019
     * @param requestDTO 查询条件
     * @return 投票活动列表
     */
    PageInfo<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO) throws Exception;
}
