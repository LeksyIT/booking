/*
package com.example.booking.controller.rest;

import com.example.booking.dto.EventDTO;
import com.example.booking.dto.EventFilterDTO;
import com.example.booking.entity.Event;
import com.example.booking.service.UserService;
import com.example.booking.service.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/RestEvent")
public class EventRestController {

    private final EventServiceImpl eventService;
    private final UserService userService;

    private static final String ID = "id";

    @GetMapping
    public List<EventDTO> showProductsList(Pageable pageable) {
        Specification<Event> specification = eventService.standardSettingSpecification(userService.getUserName());
        return eventService.getListEventDTOFromPageable(specification, pageable);
    }


    @PostMapping("/add")
    public Long addEvent(EventDTO eventDTO) {
        return  eventService.acquire(eventDTO);
    }

    @GetMapping("/filter")
    public EventFilterDTO filterEvent(@RequestParam(value = "time", required = false) Date time,
                                      @RequestParam(value = "title", required = false) String title,
                                      Pageable pageable) {

        Specification<Event> specification = eventService.additionalSettingSpecification(userService.getUserName(), title, time);
        List<EventDTO> eventDTOList = eventService.getListEventDTOFromPageable(specification, pageable);
        return new EventFilterDTO(eventDTOList,time,title);
    }

    @DeleteMapping("/delete/{id}")
    public List<EventDTO> deleteStudent(@PathVariable(value = ID) Long id) {
        eventService.deleteEvent(id);
        return eventService.getAllEvents();
    }
}
*/
