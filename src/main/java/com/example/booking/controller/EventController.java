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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event" )
public class EventController {

    private final EventServiceImpl eventService;

    private static final String EVENT = "event";
    private static final String EVENTS = "events";

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


//    @PostMapping("/add")
//    public String addEvent(Model model, EventDTO eventDTO) {
//        model.addAttribute(EVENT, eventDTO);
//        eventService.updateEvent(eventDTO);
//        return "append-event";
//    }
}
