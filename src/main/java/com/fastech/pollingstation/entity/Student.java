package com.fastech.pollingstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String phoneNumber;
    private String password;
    @ManyToOne
    @JsonIgnore
    Class_ class_;
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    @JsonIgnore
//    List<> teacherStudents;
    @Transient
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Student_Poll> studentPolls;

}
