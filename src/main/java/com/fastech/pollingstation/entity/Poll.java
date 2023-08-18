package com.fastech.pollingstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "polls")
@Setter
@Getter
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date createdAt;
    private Date endAt;
    private Boolean isActive;
    @ManyToOne
    @JsonIgnore
    Class_ class_;
}
