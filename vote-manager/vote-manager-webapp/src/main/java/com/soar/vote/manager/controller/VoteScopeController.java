package com.soar.vote.manager.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.manager.service.VoteScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <strong>添加描述</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("vote/scope")
@RestController
public class VoteScopeController {

    @Autowired
    private VoteScopeService voteScopeService;

    @GetMapping()
    ResponseEntity<PageInfo<FindVoteScopeResponseDTO>> find(FindVoteScopeRequestDTO requestDTO){

        PageInfo<FindVoteScopeResponseDTO> page = voteScopeService.find(requestDTO);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{scopeId}")
    ResponseEntity<String> delete(@PathVariable String scopeId){

        voteScopeService.delete(scopeId);

        return ResponseEntity.ok(scopeId);
    }

    @PutMapping("/{scopeId}")
    ResponseEntity<String> update(@PathVariable String scopeId, UpdateVoteScopeRequestDTO requestDTO){

        voteScopeService.update(scopeId,requestDTO);

        return ResponseEntity.ok(scopeId);
    }

}
