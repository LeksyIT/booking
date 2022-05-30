package com.example.booking.dto;

import lombok.*;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private Date endTime;
    private String resourceTitle;
    private Date startTime;
    private String userName;
}
