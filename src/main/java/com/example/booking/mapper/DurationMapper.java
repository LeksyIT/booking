package com.example.booking.mapper;

import com.example.booking.dto.DurationDTO;
import com.example.booking.entity.Duration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DurationMapper {
    @Mapping(target = "durationInterval", source = "duration.interval")
    DurationDTO toDurationDTO(Duration duration);

    @Mapping(target = "interval", source = "durationDTO.durationInterval")
    Duration toDuration(DurationDTO durationDTO);

    List<DurationDTO> toDurationDTO(List<Duration> durationList);

    List<Duration> toDuration(List<DurationDTO> durationDTOList);
}
