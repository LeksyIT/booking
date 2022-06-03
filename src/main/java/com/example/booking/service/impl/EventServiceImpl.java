package com.example.booking.service.impl;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.*;
import com.example.booking.exception.EventBookedException;
import com.example.booking.exception.NotValidDateException;
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

import java.sql.Date;
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
        if (checkNotValidDate(eventDTO.getStartTime(), eventDTO.getEndTime())) {
            throw new NotValidDateException();
        }
        Event EVENT = eventMapper.toEvent(eventDTO);
        if (eventRepository.findByDateInstanceDuration(
                EVENT.getResourceTitle(),
                EVENT.getStartTime(),
                EVENT.getEndTime()
        ).size() > 0) {
            throw new EventBookedException();
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
    public Specification<Event> additionalSettingSpecification(String userName, String title, Date time) {
        Specification<Event> specification = Specification.where(null);
        specification = specification.and(EventSpecification.userNameEqual(userName));
        if (title != null) {
            specification = specification.and(EventSpecification.findByTitle(title));
        }
        if (time != null) {
            specification = specification.and(EventSpecification.timeEqual(time));
        }
        return specification;
    }

    @Override
    public Specification<Event> standardSettingSpecification(String userName) {
        Specification<Event> specification = Specification.where(null);
        specification = specification.and(EventSpecification.userNameEqual(userName));
        return specification;
    }

    @Override
    public Page<Event> getEventWithPagingAndFiltering(Specification<Event> specifications, Pageable pageable) {
        return eventRepository.findAll(specifications, pageable);
    }

    @Override
    public List<Integer> preparePageInt(int current, int totalPages) {

        List<Integer> pageNumbers = new ArrayList<>();
        int start = Math.max(current - 5, 0);
        int end = Math.min(totalPages, start + 11);
        for (int i = start; i < end; i++) {
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
    public boolean checkNotValidDate(Date startTime, Date endTime) {
        long currentTime = System.currentTimeMillis();
        long currentTimePlus20Years = currentTime + 20 * 31536000000L;
        return startTime.after(new java.util.Date(currentTimePlus20Years)) ||
                startTime.before(new java.util.Date(currentTime)) ||
                endTime.after(new java.util.Date(currentTimePlus20Years)) ||
                endTime.before(new java.util.Date(currentTime)) ||
                startTime.after(endTime);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventMapper.toEvenDTO(eventRepository.findAll());
    }

}
