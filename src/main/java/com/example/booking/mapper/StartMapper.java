package com.example.booking.mapper;

import com.example.booking.dto.StartDTO;
import com.example.booking.entity.Start;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StartMapper {
    @Mapping(target = "startDate", source = "start.date")
    StartDTO toStartDTO(Start user);

    @Mapping(target = "date", source = "startDTO.startDate")
    Start toStart(StartDTO userDto);

    List<StartDTO> toStart(List<Start> userList);

    List<Start> toStartDTO(List<StartDTO> userDtoList);
}
