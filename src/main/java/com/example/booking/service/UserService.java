package com.example.booking.service;

import com.example.booking.dto.UserRegistrationDTO;
import com.example.booking.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDTO registrationDTO);
    String getUserName();
}
