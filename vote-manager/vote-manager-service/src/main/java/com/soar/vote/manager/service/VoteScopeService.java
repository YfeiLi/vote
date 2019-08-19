package com.soar.vote.manager.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;

/**
 * <strong>投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface VoteScopeService {

    /**
     * 添加区域
     * @author liyifei
     * @since 2/4/2019
     * @param requestDTO 添加参数
     * @return 区域编号
     */
    String add(AddVoteScopeRequestDTO requestDTO) ;

    /**
     * 删除区域
     * @author liyifei
     * @since 1/4/2019
     * @param scopeId 区域编号
     */
    void delete(String scopeId) ;

    /**
     * 查询投票区域列表
     * @author liyifei
     * @since 31/3/2019
     * @param requestDTO 查询条件
     * @return 区域列表
     */
    PageInfo<FindVoteScopeResponseDTO> find(FindVoteScopeRequestDTO requestDTO) ;

    /**
     * 修改区域
     * @author liyifei
     * @since 1/4/2019
     * @param scopeId 区域编号
     * @param requestDTO 修改参数
     */
    void update(String scopeId, UpdateVoteScopeRequestDTO requestDTO) ;
}
