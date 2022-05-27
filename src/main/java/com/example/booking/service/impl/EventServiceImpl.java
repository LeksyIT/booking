package com.example.booking.service.impl;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.*;
import com.example.booking.mapper.EventMapper;
import com.example.booking.repository.EventRepository;
import com.example.booking.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public Long acquire(EventDTO eventDTO) {
        return null;
    }

    @Override
    @Transactional
    public void updateEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEvent(eventDTO);
        eventRepository.save(event);
    }

    @Override
    public List<EventDTO> getListEventDTOFromPageable(Specification<Event> productSpecification, Pageable pageable) {
        return eventMapper.toEvenDTO(getEventWithPagingAndFiltering(productSpecification, pageable).getContent());
    }

    @Override
    public Specification<Event> settingSpecification() {
        return Specification.where(null);
    }

    @Override
    public Page<Event> getEventWithPagingAndFiltering(Specification<Event> specifications, Pageable pageable) {
        return eventRepository.findAll(specifications, pageable);
    }

    @Override
    public boolean release(Long id) {
        return false;
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public Event findByUser(String name) {
        return null;
    }

    @Override
    public Event findByTitle(Long id) {
        return null;
    }

    @Override
    public Event findByTime(Long id) {
        return null;
    }
}
