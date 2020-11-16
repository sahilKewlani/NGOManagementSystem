package com.ngo.controllers;

import com.ngo.Models.Donation;
import com.ngo.Models.Event;
import com.ngo.Models.User;
import com.ngo.Services.DonationService;
import com.ngo.Services.EventService;
import com.ngo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserService userservice;

    @Autowired
    private DonationService donationService;

    @Autowired
    private EventService eventService;

    @GetMapping("/allVolunteers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> allVolunteers() {
        return userservice.getAllVolunteers();
    }

    @GetMapping("/allDonors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> allDonors() {
        return userservice.getAllDonors();
    }

    @GetMapping("/allDonations")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Donation>> allDonations() {
        return donationService.getAllDonations();
    }

    @PostMapping("/addEvent")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @GetMapping("/allEvents")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Event>> allEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/getEvents/{id}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<List<Event>> volunteerEvents(@PathVariable("id") long userId) {
        return eventService.findByVolunteers(userId);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

}
