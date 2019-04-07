package com.soar.vote.front.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.front.service.VoteScopeService;
import com.soar.vote.persistence.entity.VoteScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <strong>投票区域</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("scope")
@RestController
public class VoteScopeController {

    @Autowired
    private VoteScopeService voteScopeService;

    @GetMapping
    ResponseEntity<PageInfo<FindVoteScopeResponseDTO>> find(FindVoteScopeRequestDTO requestDTO) throws Exception {

        PageInfo<FindVoteScopeResponseDTO> page = voteScopeService.find(requestDTO);
        return ResponseEntity.ok(page);
    }
}
