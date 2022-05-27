package com.example.booking.dto;

import com.example.booking.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long Id;
    private String userLogin;
    private Event event;
}
