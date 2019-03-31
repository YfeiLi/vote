package com.soar.vote.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.manager.service.VoteScopeService;
import com.soar.vote.persistence.mapper.VoteScopeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <strong>添加描述</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
public class VoteScopeServiceImpl implements VoteScopeService {

    @Autowired
    private VoteScopeMapper voteScopeMapper;

    @Override
    public PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO params) {

        PageHelper.startPage(params.getPageNum(),params.getPageSize());

        List<FindVoteScopeResponseDTO> list = voteScopeMapper.find(params);

        return PageInfo.of(list);
    }
}
