package com.soar.vote.manager.controller;

import com.soar.vote.common.dto.request.VoteRequestDTO;
import com.soar.vote.common.dto.request.VoterLoginRequestDTO;
import com.soar.vote.common.dto.response.VoterLoginResponseDTO;
import com.soar.vote.manager.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <strong>投票人</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("voter")
@RestController
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/login")
    ResponseEntity<VoterLoginResponseDTO> login(@RequestBody VoterLoginRequestDTO requestDTO) throws Exception{

        VoterLoginResponseDTO responseDTO = voterService.login(requestDTO);
        if(responseDTO == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/vote")
    ResponseEntity<String> vote(@RequestBody VoteRequestDTO requestDTO) throws Exception {

        String errorMsg = voterService.vote(requestDTO);
        return ResponseEntity.ok(errorMsg);
    }

}
