package com.fastech.pollingstation.controller;

import com.fastech.pollingstation.dto.VoteDto;
import com.fastech.pollingstation.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;


    @PostMapping("/add")
    public ResponseEntity<?> castVote(@RequestBody VoteDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(voteService.addVote(dto));
    }


}
