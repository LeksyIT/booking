package com.example.booking.mapper;

import com.example.booking.dto.UserRegistrationDTO;
import com.example.booking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper {
    @Mapping(target = "userRoles", source = "roles")
    @Mapping(target = "userLogin", source = "login")
    @Mapping(target = "userPassword", source = "password")
    UserRegistrationDTO toUserRegistrationDTO(User user);

    @Mapping(target = "roles", source = "userRoles")
    @Mapping(target = "login", source = "userLogin")
    @Mapping(target = "password", source = "userPassword")
    User toUserRegistration(UserRegistrationDTO userRegistrationDto);

    List<UserRegistrationDTO> toUserRegistrationDTO(List<User> userList);

    List<User> toUserRegistration(List<UserRegistrationDTO> userRegistrationDtoList);
}
