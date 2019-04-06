package com.soar.vote.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.manager.service.VoteScopeService;
import com.soar.vote.persistence.entity.VoteScope;
import com.soar.vote.persistence.mapper.VoteScopeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <strong>投票区域</strong>
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
    public String add(AddVoteScopeRequestDTO requestDTO) throws Exception {

        VoteScope entity = new VoteScope();
        BeanUtils.copyProperties(requestDTO,entity);
        String scopeId = UUIDUtil.getHashID(16);
        entity.setScopeId(scopeId);
        entity.setCreateTime(new Date());
        voteScopeMapper.insertSelective(entity);
        return scopeId;
    }

    @Override
    public void delete(String scopeId) throws Exception {

        voteScopeMapper.deleteByPrimaryKey(scopeId);
    }

    @Override
    public PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindVoteScopeResponseDTO> list = voteScopeMapper.find(requestDTO);
        return PageInfo.of(list);
    }

    @Override
    public void update(String scopeId, UpdateVoteScopeRequestDTO requestDTO) throws Exception {

        VoteScope entity = new VoteScope();
        BeanUtils.copyProperties(requestDTO,entity);
        entity.setScopeId(scopeId);
        entity.setUpdateTime(new Date());
        voteScopeMapper.updateByPrimaryKeySelective(entity);
    }
}
