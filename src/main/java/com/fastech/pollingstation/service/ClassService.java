package com.fastech.pollingstation.service;

import com.fastech.pollingstation.dto.ClassDto;
import com.fastech.pollingstation.entity.Class_;
import com.fastech.pollingstation.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;


    public Class_ addClass(ClassDto dto){
        Class_ newClass = new Class_();
        newClass.setDepartment(dto.getDepartment());
        newClass.setAcademicYear(dto.getAcademicYear());
        return classRepository.save(newClass);
    }
    public Class_ updateClass(ClassDto dto){
        Class_ classFound = classRepository.findById(dto.getId()).get();
        if(classFound != null){
            if(dto.getAcademicYear() != null)
                classFound.setAcademicYear(dto.getAcademicYear());
            if(dto.getDepartment() != null)
                classFound.setDepartment(dto.getDepartment());
            return classRepository.save(classFound);
        }
        return null;
    }

    public String deleteClass(Long classId){
        Class_ classFound = classRepository.findById(classId).get();
        classRepository.delete(classFound);
        return  "Deleted class";
    }

    public List<Class_> getAllClasses(){
        return classRepository.findAll();
    }

    public Class_ findClassById(Long classId){
        return classRepository.findById(classId).get();
    }





}
