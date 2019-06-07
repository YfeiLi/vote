package com.soar.vote.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindActivityCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindActivityCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityDetailResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.front.service.VoteActivityService;
import com.soar.vote.persistence.entity.VoteActivity;
import com.soar.vote.persistence.mapper.ActivityCandidateMapper;
import com.soar.vote.persistence.mapper.CandidateMapper;
import com.soar.vote.persistence.mapper.VoteActivityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <strong>投票活动</strong>
 * date: 5/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
public class VoteActivityServiceImpl implements VoteActivityService {

    @Autowired
    private VoteActivityMapper voteActivityMapper;

    @Autowired
    private ActivityCandidateMapper activityCandidateMapper;

    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public PageInfo<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO) {

        PageHelper.startPage(requestDTO);
        List<FindVoteActivityResponseDTO> list = voteActivityMapper.find(requestDTO);
        return PageInfo.of(list);
    }

    @Override
    public FindVoteActivityDetailResponseDTO find(String activityId) {

        VoteActivity entity = voteActivityMapper.selectByPrimaryKey(activityId);
        FindVoteActivityDetailResponseDTO responseDTO = new FindVoteActivityDetailResponseDTO();
        BeanUtils.copyProperties(entity,responseDTO);
        return responseDTO;
    }

    @Override
    public PageInfo<FindActivityCandidateResponseDTO> findCandidate(FindActivityCandidateRequestDTO requestDTO) {

        PageHelper.startPage(requestDTO);
        List<FindActivityCandidateResponseDTO> list = voteActivityMapper.findCandidate(requestDTO);
        return PageInfo.of(list);
    }
}
