package com.example.booking.service.impl;

import com.example.booking.entity.*;
import com.example.booking.mapper.EventMapper;
import com.example.booking.repository.EventRepository;
import com.example.booking.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public Long acquire(String userName, String resourceTitle, Date startTime, Date durationTime) {
        return null;
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
