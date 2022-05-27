package com.example.booking.dto;

import com.example.booking.entity.Duration;
import com.example.booking.entity.Resource;
import com.example.booking.entity.Start;
import com.example.booking.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private Duration duration;
    private Resource resource;
    private Start start;
    private User user;
}
