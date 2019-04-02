package com.soar.vote.manager.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.manager.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <strong>候选人</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("vote/candidate")
@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping()
    ResponseEntity<PageInfo<FindCandidateResponseDTO>> find(FindCandidateRequestDTO requestDTO){

        PageInfo<FindCandidateResponseDTO> page = candidateService.find(requestDTO);
        return ResponseEntity.ok(page);
    }

}
