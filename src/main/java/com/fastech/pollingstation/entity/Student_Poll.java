package com.fastech.pollingstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "polls_students")
@Setter
@Getter
public class Student_Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    Poll poll;

    @ManyToOne
    @JsonIgnore
    Student student;

}
