package com.soar.vote.manager.service;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.request.UpdateCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateDetailResponseDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;

/**
 * <strong>候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface CandidateService {

    /**
     * 新增候选人
     * @author liyifei
     * @date 3/4/2019
     * @param requestDTO 新增内容
     * @return 候选人编号
     */
    String add(AddCandidateRequestDTO requestDTO) throws Exception;

    /**
     * 删除候选人
     * @author liyifei
     * @date 3/4/2019
     * @param candidateId 候选人编号
     */
    void delete(String candidateId) throws Exception;

    /**
     * 查询候选人列表
     * @author liyifei
     * @date 4/4/2019
     * @param requestDTO 查询条件
     * @return 候选人列表
     */
    PageInfo<FindCandidateResponseDTO> find(FindCandidateRequestDTO requestDTO) throws Exception;

    /**
     * 查询候选人详情
     * @author liyifei
     * @date 4/4/2019
     * @param candidateId 候选人编号
     * @return 候选人
     */
    FindCandidateDetailResponseDTO find(String candidateId) throws Exception;

    /**
     * 修改候选人
     * @author liyifei
     * @date 4/4/2019
     * @author liyifei
     * @date 3/4/2019
     * @param candidateId 候选人编号
     * @param requestDTO 修改内容
     */
    void update(String candidateId, UpdateCandidateRequestDTO requestDTO) throws Exception;
}
