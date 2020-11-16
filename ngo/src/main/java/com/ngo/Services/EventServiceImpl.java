package com.ngo.Services;

import com.ngo.Models.*;
import com.ngo.Repository.EventRepository;
import com.ngo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<List<Event>> getAllEvents() {
        try {
            List<Event> events = new ArrayList<Event>();

            eventRepository.findAll().forEach(events::add);

            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Event>> findByVolunteers(long userId){
        try {
            List<Event> events = new ArrayList<Event>();

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));
            eventRepository.findByVolunteers(user).forEach(events::add);

            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Event> addEvent(Event event){
        try {
            Event eventObj = new Event();
            eventObj.setName(event.getName());
            eventObj.setDescription(event.getDescription());
            eventObj.setDate(event.getDate());
            eventObj.setVenue(event.getVenue());
            Event _event = eventRepository
                    .save(eventObj);
            return new ResponseEntity<>(_event, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Event> registerForEvent(long userId, long eventId){
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));
            Event event = eventRepository.findById(eventId)
                    .orElseThrow(() -> new RuntimeException("Error: Event is not found."));
            event.getVolunteers().add(user);
            Event _event = eventRepository
                    .save(event);
            return new ResponseEntity<>(_event, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
