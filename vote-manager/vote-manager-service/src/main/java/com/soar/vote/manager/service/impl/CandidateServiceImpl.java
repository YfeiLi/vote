package com.soar.vote.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.request.UpdateCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateDetailResponseDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.common.util.Base64PicUtil;
import com.soar.vote.common.util.UUIDUtil;
import com.soar.vote.manager.service.CandidateService;
import com.soar.vote.persistence.entity.Candidate;
import com.soar.vote.persistence.mapper.CandidateMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /** 照片保存路径 */
    private static String PIC_BASE_DIR ="/home/soar/picture/vote/candidate/";
    /** 照片访问路径 */
    private static String PIC_BASE_URL = "https://www.yfei.site/picture/vote/candidate/";

    @Override
    public String add(AddCandidateRequestDTO requestDTO) throws Exception {

        String candidateId = UUIDUtil.getHashID(12);
        String fileName = System.currentTimeMillis()+".jpg";
        Map<String,Short> picSize = Base64PicUtil.saveBase64Picture(requestDTO.getPhoto(), PIC_BASE_DIR+fileName);
        Candidate entity = new Candidate();
        BeanUtils.copyProperties(requestDTO,entity);
        entity.setCandidateId(candidateId);
        entity.setPhotoUrl(PIC_BASE_URL+fileName);
        entity.setCreateTime(new Date());
        entity.setPhotoWidth(picSize.get("width"));
        entity.setPhotoHeight(picSize.get("height"));
        candidateMapper.insertSelective(entity);
        return candidateId;
    }

    @Override
    public void delete(String candidateId) throws Exception {
        candidateMapper.deleteByPrimaryKey(candidateId);
    }

    @Override
    public PageInfo<FindCandidateResponseDTO> find(FindCandidateRequestDTO requestDTO) throws Exception {

        PageHelper.startPage(requestDTO);
        List<FindCandidateResponseDTO> list = candidateMapper.find(requestDTO);
        return PageInfo.of(list);
    }

    @Override
    public FindCandidateDetailResponseDTO find(String candidateId) throws Exception {

        Candidate entity = candidateMapper.selectByPrimaryKey(candidateId);
        FindCandidateDetailResponseDTO responseDTO = new FindCandidateDetailResponseDTO();
        BeanUtils.copyProperties(entity,responseDTO);
        return responseDTO;
    }

    @Override
    public void update(String candidateId, UpdateCandidateRequestDTO requestDTO) throws Exception {

        Candidate entity = new Candidate();
        BeanUtils.copyProperties(requestDTO,entity);
        if(!StringUtils.isEmpty(requestDTO.getPhoto())){
            String fileName = System.currentTimeMillis()+".jpg";
            Map<String,Short> picSize = Base64PicUtil.saveBase64Picture(requestDTO.getPhoto(),PIC_BASE_DIR+fileName);
            entity.setPhotoUrl(PIC_BASE_URL+fileName);
            entity.setPhotoWidth(picSize.get("width"));
            entity.setPhotoHeight(picSize.get("height"));
        }
        entity.setCandidateId(candidateId);
        entity.setUpdateTime(new Date());
        candidateMapper.updateByPrimaryKeySelective(entity);
    }
}
