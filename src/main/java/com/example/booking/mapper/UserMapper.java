package com.example.booking.mapper;

import com.example.booking.dto.UserDTO;
import com.example.booking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userRoles", source = "user.roles")
    @Mapping(target = "userLogin", source = "user.login")
    @Mapping(target = "userPassword", source = "user.password")
    UserDTO toUserDTO(User user);

    @Mapping(target = "roles", source = "userDto.userRoles")
    @Mapping(target = "login", source = "userDto.userLogin")
    @Mapping(target = "password", source = "userDto.userPassword")
    User toUser(UserDTO userDto);

    List<UserDTO> toUserDTO(List<User> userList);

    List<User> toUser(List<UserDTO> userDtoList);
}
