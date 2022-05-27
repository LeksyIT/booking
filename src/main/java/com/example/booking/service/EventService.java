package com.example.booking.service;

import com.example.booking.entity.*;

import java.util.Date;

public interface EventService {
    Long acquire(String userName, String resourceTitle, Date startTime, Date durationTime);

    boolean release(Long id);

    Event findById(Long id);

    Event findByUser(String name);

    Event findByTitle(Long id);

    Event findByTime(Long id);
}
