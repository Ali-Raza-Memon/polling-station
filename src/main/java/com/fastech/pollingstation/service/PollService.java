package com.fastech.pollingstation.service;

import com.fastech.pollingstation.dto.PollDto;
import com.fastech.pollingstation.entity.Class_;
import com.fastech.pollingstation.entity.Poll;
import com.fastech.pollingstation.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private ClassService classService;

    public List<Poll> findPollsByStudentId(Long studentId) {
        return pollRepository.findByClass_Polls_Student_Id(studentId);
    }




    public Poll addPoll(PollDto pollDto){
        Class_ classFound = classService.findClassById(pollDto.getClassId());
        Poll newPoll = new Poll();
        newPoll.setTitle(pollDto.getTitle());
        newPoll.setCreatedAt(new Date());
        newPoll.setClass_(classFound);
            return pollRepository.save(newPoll);
    }

    public Poll findPollById(Long id){
        return pollRepository.findById(id).get();
    }

    public Poll updatePoll(PollDto dto){

        Poll pollFound = pollRepository.findById(dto.getId()).get();
        if( pollFound != null){

            if(dto.getTitle() != null)
                pollFound.setTitle(dto.getTitle());
            return pollRepository.save(pollFound);
        }
        return null;
    }

    public List<Poll> findAllPolls(){
        return pollRepository.findAll();
    }

    public String deletePoll(Long id){
        Poll pollFound = pollRepository.findById(id).get();
        pollRepository.delete(pollFound);
        return "Deleted poll";
    }






}
