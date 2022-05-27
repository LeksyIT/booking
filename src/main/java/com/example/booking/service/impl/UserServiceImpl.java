package com.example.booking.service.impl;

import com.example.booking.dto.UserDTO;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    private final UserDTO userDTO;

    @Override
    public String getUserName() {
        return null;
    }
}
