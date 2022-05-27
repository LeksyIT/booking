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
        Event EVENT = eventMapper.toEvent(eventDTO);
        List<Event> eventsByTitle = eventRepository.getByResourceTitle(eventDTO.getResourceTitle());
        if (eventRepository.findByDateInstanceDuration(
                EVENT.getResourceTitle(),
                EVENT.getStartTime(),
                EVENT.getEndTime()
        ).size() > 0) {
            //TODO:Сделать эксепшин хендлер
            throw new RuntimeException();
        }
        updateEvent(eventDTO);

        return eventDTO.getId();
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
        //TODO:to realize normal specification
        return Specification.where(null);
    }

    @Override
    public Page<Event> getEventWithPagingAndFiltering(Specification<Event> specifications, Pageable pageable) {
        return eventRepository.findAll(specifications, pageable);
    }

    @Override
    public boolean release(Long id) {
        //TODO:to realize
        return false;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.delete(eventRepository.findById(id).orElseThrow());
    }

    @Override
    public Event findById(Long id) {
        //TODO:to realize
        return null;
    }

    @Override
    public Event findByUser(String name) {
        //TODO:to realize
        return null;
    }

    @Override
    public Event findByTitle(Long id) {
        //TODO:to realize
        return null;
    }

    @Override
    public Event findByTime(Long id) {
        //TODO:to realize
        return null;
    }
}
