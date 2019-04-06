package com.soar.vote.manager.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.AddVoteActivityRequestDTO;
import com.soar.vote.common.dto.request.FindCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.manager.service.VoteActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <strong>投票活动</strong>
 * date: 4/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("vote/activity")
@RestController
public class VoteActivityController {

    @Autowired
    private VoteActivityService voteActivityService;

    @PostMapping
    ResponseEntity<String> add(@RequestBody AddVoteActivityRequestDTO requestDTO){

        String activityId = voteActivityService.add(requestDTO);
        return ResponseEntity.ok(activityId);
    }

    @GetMapping
    ResponseEntity<PageInfo<FindVoteActivityResponseDTO>> find(FindVoteActivityRequestDTO requestDTO) throws Exception{

        PageInfo<FindVoteActivityResponseDTO> page = voteActivityService.find(requestDTO);
        return ResponseEntity.ok(page);
    }
}
