package com.fastech.pollingstation.controller;

import com.fastech.pollingstation.dto.ClassDto;
import com.fastech.pollingstation.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("/add")
    public ResponseEntity<?> addClass(@RequestBody ClassDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(classService.addClass(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateClass(@RequestBody ClassDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(classService.updateClass(dto));
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(classService.findClassById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(classService.getAllClasses());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClass(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(classService.deleteClass(id));
    }

}
