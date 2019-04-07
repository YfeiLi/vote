package com.soar.vote.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.front.service.VoteScopeService;
import com.soar.vote.persistence.mapper.VoteScopeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <strong>投票区域</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
@Slf4j
public class VoteScopeServiceImpl implements VoteScopeService {

    @Autowired
    private VoteScopeMapper voteScopeMapper;

    @Override
    public PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindVoteScopeResponseDTO> list = voteScopeMapper.find(requestDTO);
        return PageInfo.of(list);
    }
}
