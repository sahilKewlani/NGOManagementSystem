package com.ngo.Services;

import com.ngo.Models.Event;
import com.ngo.Models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {
    public ResponseEntity<List<Event>> getAllEvents();
    public ResponseEntity<List<Event>> findByVolunteers(long userId);
    public ResponseEntity<Event> addEvent(Event event);
}
