package com.example.booking.service.impl;

import com.example.booking.dto.EventDTO;
import com.example.booking.exception.EventBookedException;
import com.example.booking.exception.NotValidDateException;
import com.example.booking.repository.EventRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql","/create-event-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql","/create-event-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithUserDetails(value = "adminTest")
class EventServiceImplTest {

    @Autowired
    private EventServiceImpl eventService;

    @Test
    void checkServiceImplBeanWork() {
        assertThat(eventService).isNotNull();
    }

    @Test
    void acquireInTheBusyRange() {
        EventDTO test = new EventDTO(1000L,
                "123",
                "test1",
                new Date(System.currentTimeMillis() + 19 * 31536000000L),
                new Date(System.currentTimeMillis() + 10L));
        Assert.assertThrows(EventBookedException.class,() -> eventService.acquire(test));
    }

    @Test
    void acquireOutOfRangeBefore() {
        EventDTO test = new EventDTO(1000L,
                "1234",
                "test2",
                new Date(System.currentTimeMillis() + 10000000),
                new Date(System.currentTimeMillis() - 10002000));
        Assert.assertThrows(NotValidDateException.class,() -> eventService.acquire(test));
    }

    @Test
    void acquireOutOfRangeAfter() {
        EventDTO test = new EventDTO(1000L,
                "12345",
                "test3",
                new Date(System.currentTimeMillis() + 21 * 31536000000L),
                new Date(System.currentTimeMillis() + 1000L ));
        Assert.assertThrows(NotValidDateException.class,() -> eventService.acquire(test));
    }

    @Test
    void deleteEvent() {
        eventService.deleteEvent(1L);
        Assert.assertThrows(Exception.class,()->eventService.deleteEvent(1L));
    }
}