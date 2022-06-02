package com.example.booking.controller;

import com.example.booking.dto.EventDTO;
import com.example.booking.entity.Event;
import com.example.booking.service.UserService;
import com.example.booking.service.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventServiceImpl eventService;
    private final UserService userService;

    private static final String EVENT = "event";
    private static final String EVENTS = "events";
    private static final String ID = "id";
    private static final String REDIRECT_EVENT = "redirect:/event";

    @GetMapping
    public String showProductsList(Model model,
//                                   @RequestParam(value = "time", required = false) Date time,
//                                   @RequestParam(value = "title", required = false) String title,
                                   EventDTO eventDTO,
                                   Pageable pageable) {


        Specification<Event> specification = eventService.standardSettingSpecification(userService.getUserName());
//        Page<Event> modelsPages = eventService.getEventWithPagingAndFiltering(specification, pageable);
        List<EventDTO> eventDTOList = eventService.getListEventDTOFromPageable(specification, pageable);

        model.addAttribute(EVENTS, eventDTOList);
        model.addAttribute(EVENT, eventDTO);
//        model.addAttribute("time", time);
//        model.addAttribute("title", title);
        model.addAttribute("userName", userService.getUserName());
//        model.addAttribute("currentPage", pageable.getPageNumber());
//        model.addAttribute("pageNumbers", eventService.preparePageInt(pageable.getPageNumber(), modelsPages.getTotalPages()));

        return "event";
    }


    @PostMapping("/add")
    public String addEvent(Model model, EventDTO eventDTO) {
        model.addAttribute(EVENT, eventDTO);
        eventService.acquire(eventDTO);
        return REDIRECT_EVENT;
    }

    @GetMapping("/filter")
    public String filterEvent(Model model,
                              @RequestParam(value = "time", required = false) Date time,
                              @RequestParam(value = "title", required = false) String title,
                              EventDTO eventDTO,
                              Pageable pageable) {
        Specification<Event> specification = eventService.additionalSettingSpecification(userService.getUserName(), title, time);
        List<EventDTO> eventDTOList = eventService.getListEventDTOFromPageable(specification, pageable);
        model.addAttribute("userName", userService.getUserName());
////        model.addAttribute("time", time);
////        model.addAttribute("title", title);
        model.addAttribute(EVENTS, eventDTOList);
        model.addAttribute(EVENT, eventDTO);
        return EVENT;
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = ID) Long id) {
        eventService.deleteEvent(id);
        return REDIRECT_EVENT;
    }
}
