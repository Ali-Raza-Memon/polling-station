package com.fastech.pollingstation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoteDto {
    private Long id;
    private Long studentId;
    private Long pollId;

}
