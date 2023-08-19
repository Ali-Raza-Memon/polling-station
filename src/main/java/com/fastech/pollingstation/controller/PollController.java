package com.fastech.pollingstation.controller;

import com.fastech.pollingstation.dto.PollDto;
import com.fastech.pollingstation.entity.Poll;
import com.fastech.pollingstation.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/add")
    public ResponseEntity<?> addPoll(@RequestBody PollDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(pollService.addPoll(dto));
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pollService.findPollById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pollService.findAllPolls());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePoll(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pollService.deletePoll(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePoll(@RequestBody PollDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(pollService.updatePoll(dto));
    }


    @GetMapping("/studentId")
    public ResponseEntity<List<Poll>> getPollsByStudentId(@RequestParam Long studentId) {
        List<Poll> polls = pollService.findPollsByStudentId(studentId);

        if (polls.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(polls);
    }



}
