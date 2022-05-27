package com.example.booking.mapper;


import com.example.booking.dto.EventDTO;
import com.example.booking.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toEvenDTO(Event event);

    Event toEvent(EventDTO eventDTO);

    List<EventDTO> toEvenDTO(List<Event> eventList);

    List<Event> toEvent(List<EventDTO> eventDTOList);
}
