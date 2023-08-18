package com.fastech.pollingstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
@Setter
@Getter
public class Class_ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long academicYear;
    private String department;

    @OneToMany(mappedBy = "class_", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Student> students;

    @OneToMany(mappedBy = "class_", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Poll> polls;



}
