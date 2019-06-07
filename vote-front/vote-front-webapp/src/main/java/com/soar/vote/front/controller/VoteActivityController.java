package com.soar.vote.front.controller;

import com.github.pagehelper.PageInfo;
import com.soar.vote.common.dto.request.FindActivityCandidateRequestDTO;
import com.soar.vote.common.dto.request.FindVoteActivityRequestDTO;
import com.soar.vote.common.dto.response.FindActivityCandidateResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityDetailResponseDTO;
import com.soar.vote.common.dto.response.FindVoteActivityResponseDTO;
import com.soar.vote.front.service.VoteActivityService;
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
@RequestMapping("activity")
@RestController
public class VoteActivityController {

    @Autowired
    private VoteActivityService voteActivityService;

    @GetMapping("/{activityId}")
    ResponseEntity<FindVoteActivityDetailResponseDTO> find(@PathVariable String activityId) {

        FindVoteActivityDetailResponseDTO responseDTO = voteActivityService.find(activityId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    ResponseEntity<PageInfo<FindVoteActivityResponseDTO>> find(FindVoteActivityRequestDTO requestDTO) {

        PageInfo<FindVoteActivityResponseDTO> page = voteActivityService.find(requestDTO);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/candidate")
    ResponseEntity<PageInfo<FindActivityCandidateResponseDTO>> findCandidate(FindActivityCandidateRequestDTO requestDTO) {

        PageInfo<FindActivityCandidateResponseDTO> page = voteActivityService.findCandidate(requestDTO);
        return ResponseEntity.ok(page);
    }
}
