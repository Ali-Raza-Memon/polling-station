package com.fastech.pollingstation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private Long classId;
}
