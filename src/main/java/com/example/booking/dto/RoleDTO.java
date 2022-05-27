package com.example.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private long Id;
    private String roleName;
    private Collection<UserRegistrationDTO> users;
}
