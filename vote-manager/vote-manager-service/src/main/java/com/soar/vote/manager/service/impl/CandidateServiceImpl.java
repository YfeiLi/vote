package com.soar.vote.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.manager.service.CandidateService;
import com.soar.vote.persistence.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <strong>候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public PageInfo<FindCandidateResponseDTO> find(FindCandidateRequestDTO requestDTO) {

        PageHelper.startPage(requestDTO);
        List<FindCandidateResponseDTO> list = candidateMapper.find(requestDTO);
        return PageInfo.of(list);
    }
}
