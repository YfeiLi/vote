package com.soar.vote.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteActivityRequestDTO;
import com.soar.vote.common.dto.request.FindActivityCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindActivityCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.manager.service.VoteActivityService;
import com.soar.vote.persistence.entity.ActivityCandidate;
import com.soar.vote.persistence.entity.Candidate;
import com.soar.vote.persistence.entity.VoteActivity;
import com.soar.vote.persistence.mapper.ActivityCandidateMapper;
import com.soar.vote.persistence.mapper.CandidateMapper;
import com.soar.vote.persistence.mapper.VoteActivityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Transactional(rollbackFor = Exception.class)
    public String add(AddVoteActivityRequestDTO requestDTO) {

        String activityId = UUIDUtil.getHashID(18);
        VoteActivity entity = new VoteActivity();
        BeanUtils.copyProperties(requestDTO,entity);
        entity.setActivityId(activityId);
        entity.setCreateTime(new Date());
        voteActivityMapper.insertSelective(entity);
        List<Candidate> candidateList = candidateMapper.selectByScopeIdRecursive(requestDTO.getScopeId());
        short candidateCode = 1;
        for (Candidate candidate : candidateList) {
            ActivityCandidate activityCandidate = new ActivityCandidate();
            activityCandidate.setActivityCandidateId(UUIDUtil.getUUID());
            activityCandidate.setActivityId(activityId);
            activityCandidate.setCandidateId(candidate.getCandidateId());
            activityCandidate.setCandidateCode(candidateCode++);
            activityCandidate.setVotes((short)0);
            activityCandidate.setCreateTime(new Date());
            activityCandidateMapper.insertSelective(activityCandidate);
        }
        return activityId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delete(String activityId) {

        ActivityCandidate activityCandidate = new ActivityCandidate();
        activityCandidate.setActivityId(activityId);
        activityCandidateMapper.delete(activityCandidate);
        voteActivityMapper.deleteByPrimaryKey(activityId);
        return activityId;
    }

    @Override
    public PageInfo<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindVoteActivityResponseDTO> list = voteActivityMapper.find(requestDTO);
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<FindActivityCandidateResponseDTO> findCandidate(FindActivityCandidateRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindActivityCandidateResponseDTO> list = voteActivityMapper.findCandidate(requestDTO);
        return PageInfo.of(list);
    }
}
