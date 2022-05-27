package com.example.booking.service;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;

public interface EventService {
    Long acquire(EventDTO eventDTO);

    void updateEvent(EventDTO eventDTO);

    List<EventDTO> getListEventDTOFromPageable(Specification<Event> productSpecification, Pageable pageable);

    public Specification<Event> settingSpecification();

    public Page<Event> getEventWithPagingAndFiltering(Specification<Event> specifications, Pageable pageable);

    boolean release(Long id);

    Event findById(Long id);

    Event findByUser(String name);

    Event findByTitle(Long id);

    Event findByTime(Long id);
}
