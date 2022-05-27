package com.example.booking.service.impl;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.*;
import com.example.booking.mapper.EventMapper;
import com.example.booking.repository.EventRepository;
import com.example.booking.service.EventService;
import com.example.booking.service.UserService;
import com.example.booking.specification.EventSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    private final UserService userService;

    @Override
    public Long acquire(EventDTO eventDTO) {
        Event EVENT = eventMapper.toEvent(eventDTO);
        if (eventRepository.findByDateInstanceDuration(
                EVENT.getResourceTitle(),
                EVENT.getStartTime(),
                EVENT.getEndTime()
        ).size() > 0) {
            //TODO:Сделать эксепшин хендлер. Сделать разные ошибки
            throw new RuntimeException();
        }
        updateEvent(eventDTO);

        return eventDTO.getId();
    }

    @Override
    @Transactional
    public void updateEvent(EventDTO eventDTO) {
        eventDTO.setUserName(userService.getUserName());
        Event event = eventMapper.toEvent(eventDTO);
        eventRepository.save(event);
    }

    @Override
    public List<EventDTO> getListEventDTOFromPageable(Specification<Event> productSpecification, Pageable pageable) {
        return eventMapper.toEvenDTO(getEventWithPagingAndFiltering(productSpecification, pageable).getContent());
    }

    @Override
    public Specification<Event> settingSpecification(String userName) {
        Specification<Event> specification = Specification.where(null);
        specification = specification.and(EventSpecification.titleEqual(userName));
        return specification;
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
    public List<Integer> preparePageInt(int current, int totalPages) {

        List<Integer> pageNumbers = new ArrayList<>();
        int start = Math.max(current - 5, 0);
        int end = Math.min(totalPages,start+11);
        for (int i = start;i<end;i++){
            pageNumbers.add(i);
        }
        return pageNumbers;
    }

    @Override
    public String getUserName(Long id) {
        return eventRepository.getReferenceById(id).getUserName();
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
