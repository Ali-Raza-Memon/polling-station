package com.fastech.pollingstation.service;

import com.fastech.pollingstation.dto.StudentDto;
import com.fastech.pollingstation.dto.StudentPollDto;
import com.fastech.pollingstation.entity.Class_;
import com.fastech.pollingstation.entity.Poll;
import com.fastech.pollingstation.entity.Student;
import com.fastech.pollingstation.entity.Student_Poll;
import com.fastech.pollingstation.repository.PollRepository;
import com.fastech.pollingstation.repository.StudentPollRepository;
import com.fastech.pollingstation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassService classService;
    @Autowired
    private PollService pollService;

    @Autowired
    private StudentPollRepository studentPollRepository;


    public Student addStudent(StudentDto dto){
        Class_ classFound = classService.findClassById(dto.getClassId());
        Student student = new Student();
        student.setCity(dto.getCity());
        student.setEmail(dto.getEmail());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setClass_(classFound);
        return studentRepository.save(student);
    }
    public Student findStudentById(Long id){
        return studentRepository.findById(id).get();
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(StudentDto dto){
        Student student = studentRepository.findById(dto.getId()).get();

        if(student != null){

            if(dto.getCity() != null){
                student.setCity(dto.getCity());
            }
            if(dto.getEmail() != null){
                student.setEmail(dto.getEmail());
            }
            if(dto.getFirstName() != null){
                student.setFirstName(dto.getFirstName());
            }
            if(dto.getLastName() != null){
                student.setLastName(dto.getLastName());
            }

            return studentRepository.save(student);
        }
        return null;
    }

    public String deleteStudent(Long id){
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return "Deleted student";
    }


    public String selectStudentForPoll(StudentPollDto dto){

        Student selectedStudent = findStudentById(dto.getStudentId());
        Poll selectedPoll = pollService.findPollById(dto.getPollId());
        Student_Poll studentPoll = new Student_Poll();
        studentPoll.setPoll(selectedPoll);
        studentPoll.setStudent(selectedStudent);
        studentPollRepository.save(studentPoll);
        return "Selected Student added for the Poll";
    }






}
