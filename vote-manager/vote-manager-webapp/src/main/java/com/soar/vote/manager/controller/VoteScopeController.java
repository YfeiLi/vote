package com.soar.vote.manager.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.FindVoteScopeRequestDTO;
import com.soar.vote.common.dto.request.UpdateVoteScopeRequestDTO;
import com.soar.vote.common.dto.response.FindVoteScopeResponseDTO;
import com.soar.vote.manager.service.VoteScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <strong>投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("scope")
@RestController
public class VoteScopeController {

    @Autowired
    private VoteScopeService voteScopeService;

    @PostMapping
    ResponseEntity<String> add(@RequestBody AddVoteScopeRequestDTO requestDTO) {

        String scopeId = voteScopeService.add(requestDTO);
        return ResponseEntity.ok(scopeId);
    }

    @DeleteMapping("/{scopeId}")
    ResponseEntity<String> delete(@PathVariable String scopeId) {

        voteScopeService.delete(scopeId);
        return ResponseEntity.ok(scopeId);
    }

    @GetMapping
    ResponseEntity<PageInfo<FindVoteScopeResponseDTO>> find(FindVoteScopeRequestDTO requestDTO) {

        PageInfo<FindVoteScopeResponseDTO> page = voteScopeService.find(requestDTO);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{scopeId}")
    ResponseEntity<String> update(@PathVariable String scopeId, UpdateVoteScopeRequestDTO requestDTO) {

        voteScopeService.update(scopeId,requestDTO);
        return ResponseEntity.ok(scopeId);
    }

}
