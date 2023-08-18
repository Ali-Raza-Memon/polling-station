package com.fastech.pollingstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "votes")
@Setter
@Getter
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    @OneToOne
    @JsonIgnore
    private Student student;
    @OneToOne
    @JsonIgnore
    private Poll poll_;
}
