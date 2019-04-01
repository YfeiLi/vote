package com.soar.vote.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.manager.service.VoteScopeService;
import com.soar.vote.persistence.entity.VoteScope;
import com.soar.vote.persistence.mapper.VoteScopeMapper;
import org.springframework.beans.BeanUtils;
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
    public PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO) {

        PageHelper.startPage(requestDTO);

        List<FindVoteScopeResponseDTO> list = voteScopeMapper.find(requestDTO);

        return PageInfo.of(list);
    }

    @Override
    public void delete(String scopeId) {

        voteScopeMapper.deleteByPrimaryKey(scopeId);
    }

    @Override
    public void update(String scopeId, UpdateVoteScopeRequestDTO requestDTO) {

        VoteScope entity = new VoteScope();
        BeanUtils.copyProperties(requestDTO,entity);
        entity.setScopeId(scopeId);
        voteScopeMapper.updateByPrimaryKeySelective(entity);
    }
}
