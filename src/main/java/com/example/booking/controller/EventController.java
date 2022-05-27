package com.example.booking.controller;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.Event;
import com.example.booking.service.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event" )
public class EventController {

    private final EventServiceImpl eventService;

    private static final String EVENT = "event";
    private static final String EVENTS = "events";
    private static final String ID = "id";
    private static final String REDIRECT_EVENT = "redirect:/event";

    @GetMapping
    public String showProductsList(Model model,
                                   EventDTO eventDTO,
                                   Pageable pageable) {

        Specification<Event> specification = eventService.settingSpecification();
        List<EventDTO> eventDTOList = eventService.getListEventDTOFromPageable(specification, pageable);

        model.addAttribute(EVENTS, eventDTOList);
        System.out.println(eventDTOList);
        model.addAttribute(EVENT, eventDTO);
        return "append-event";
    }


    @PostMapping("/add")
    public String addEvent(Model model, EventDTO eventDTO) {
        model.addAttribute(EVENT, eventDTO);
        eventService.acquire(eventDTO);
        return "redirect:/event";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = ID) Long id) {
        eventService.deleteEvent(id);
        return REDIRECT_EVENT;
    }
}
