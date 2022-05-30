package com.example.booking.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EventServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventServiceImpl eventService;

    @Test
    void checkServiceImplBeanWork(){
        assertThat(eventService).isNotNull();
    }

    @Test
    void acquire() {
    }

    @Test
    void updateEvent() {
    }

    @Test
    void additionalSettingSpecification() {
    }

    @Test
    void checkNotValidDate() {
    }
}