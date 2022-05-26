package com.example.booking.dto;

import com.example.booking.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartDTO {
    private long Id;
    private Event event;
    private Date startDate;
}
