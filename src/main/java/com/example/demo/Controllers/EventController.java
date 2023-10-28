package com.example.demo.Controllers;

import com.example.demo.Models.Event;
import com.example.demo.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

//    @GetMapping
//    public String listEvents(Model model) {
//       Iterable<Event> events = eventRepository.findAll();
//       model.addAttribute("events", events);
//       return "event/list";
//   }
//
//
    @GetMapping
    public List<Event> findAll (){
        return eventRepository.findAll();
    }



    @GetMapping("/{id}")
    public String showEvent(@PathVariable("id") Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            model.addAttribute("event", event);
            return "event/show";
        } else {
            return "event/not_found";
        }
    }

    @GetMapping("/create")
    public String createEventForm() {
        return "event/create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    @GetMapping("/{id}/edit")
    public String editEventForm(@PathVariable("id") Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            model.addAttribute("event", event);
            return "event/edit";
        } else {
            return "event/not_found";
        }
    }

    @PostMapping("/{id}/edit")
    public String editEvent(@PathVariable("id") Long id, @ModelAttribute Event updatedEvent) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setLocation(updatedEvent.getLocation());
            event.setDate(updatedEvent.getDate());
            event.setPoints(updatedEvent.getPoints());
            eventRepository.save(event);
            return "redirect:/events";
        } else {
            return "event/not_found";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }
}
