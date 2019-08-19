package com.soar.vote.manager.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteActivityRequestDTO;
import com.soar.vote.common.dto.request.FindActivityCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindActivityCandidateResponseDTO;
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
     * @since 5/4/2019
     * @param requestDTO 添加内容
     * @return 活动编号
     */
    String add(AddVoteActivityRequestDTO requestDTO);

    /**
     * 删除投票活动
     * @author liyifei
     * @since 6/4/2019
     * @param activityId 活动编号
     * @return 活动编号
     */
    String delete(String activityId);

    /**
     * 查询投票活动列表
     * @author liyifei
     * @since 5/4/2019
     * @param requestDTO 查询条件
     * @return 投票活动列表
     */
    PageInfo<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO) ;

    /**
     * 查询活动候选人列表
     * @author liyifei
     * @since 6/4/2019
     * @param requestDTO 查询条件
     * @return 活动候选人列表
     */
    PageInfo<FindActivityCandidateResponseDTO> findCandidate(FindActivityCandidateRequestDTO requestDTO) ;
}
