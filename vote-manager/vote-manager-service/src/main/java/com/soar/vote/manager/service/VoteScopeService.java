package com.soar.vote.manager.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;

/**
 * <strong>投票区域</strong>
 *
 * @author liyifei
 * @version 1.0
 **/
public interface VoteScopeService {

    /**
     * 查询列表
     * @author liyifei
     * @date 31/3/2019
     * @param requestDTO 查询条件
     * @return 区域列表
     */
    PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO);

    /**
     * 删除区域
     * @author liyifei
     * @date 1/4/2019
     * @param scopeId 区域编号
     */
    void delete(String scopeId);

    /**
     * 修改区域
     * @author liyifei
     * @date 1/4/2019
     * @param scopeId 区域编号
     * @param requestDTO 修改参数
     */
    void update(String scopeId, UpdateVoteScopeRequestDTO requestDTO);
}
