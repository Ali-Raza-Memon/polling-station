package com.fastech.pollingstation.controller;

import com.fastech.pollingstation.dto.StudentDto;
import com.fastech.pollingstation.repository.StudentRepository;
import com.fastech.pollingstation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addStudent(dto));
    }

   @GetMapping("/findById")
   private ResponseEntity<?> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(id));
   }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudents());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(id));
    }


}
