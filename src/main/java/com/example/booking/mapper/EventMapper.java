package com.example.booking.mapper;


import com.example.booking.dto.EventDTO;
import com.example.booking.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    @Mapping(target = "resourceTitle", source = "resource.title")
    EventDTO toEvenDTO(Event event);

    @Mapping(target = "title", source = "resourceDTO.resourceTitle")
    Event toEvent(EventDTO eventDTO);

    List<EventDTO> toEvenDTO(List<Event> eventList);

    List<Event> toEvent(List<EventDTO> eventDTOList);
}
