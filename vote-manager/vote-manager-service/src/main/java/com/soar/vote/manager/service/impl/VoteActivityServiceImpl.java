package com.soar.vote.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.manager.service.VoteActivityService;
import com.soar.vote.persistence.mapper.VoteActivityMapper;
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

    @Override
    public PageInfo<FindVoteActivityResponseDTO> find(FindVoteActivityRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindVoteActivityResponseDTO> list = voteActivityMapper.find(requestDTO);
        return PageInfo.of(list);
    }
}
