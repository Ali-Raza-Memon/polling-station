package com.fastech.pollingstation.service;

import com.fastech.pollingstation.dto.PollDto;
import com.fastech.pollingstation.dto.VoteDto;
import com.fastech.pollingstation.entity.Class_;
import com.fastech.pollingstation.entity.Poll;
import com.fastech.pollingstation.entity.Student;
import com.fastech.pollingstation.entity.Vote;
import com.fastech.pollingstation.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VoteService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private PollService pollService;
    @Autowired
    private VoteRepository voteRepository;

    public Vote addVote(VoteDto dto){
        Student student = studentService.findStudentById(dto.getStudentId());
        Poll poll = pollService.findPollById(dto.getPollId());
        Vote newVote = new Vote();
        newVote.setPoll_(poll);
        newVote.setStudent(student);
        newVote.setCreatedAt(new Date());
        return voteRepository.save(newVote);
    }


}
