package com.example.booking.dto;


import com.example.booking.entity.User;
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
//    private User user;
}
