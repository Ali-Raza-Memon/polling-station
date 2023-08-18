package com.fastech.pollingstation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PollDto {
    private Long id;
    private String title;
    private Date createdAt;
    private Date endAt;
    private Boolean isActive;
    private Long classId;
}
