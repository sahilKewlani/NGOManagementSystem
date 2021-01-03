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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
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
    @PreAuthorize("hasRole('ADMIN') || hasRole('VOLUNTEER')")
    public ResponseEntity<List<Event>> allEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/getEvents/{id}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<List<Event>> volunteerEvents(@PathVariable("id") long userId) {
        return eventService.findByVolunteers(userId);
    }

    @GetMapping("/getDonations/{id}")
    @PreAuthorize("hasRole('DONOR')")
    public ResponseEntity<List<Donation>> donorDonations(@PathVariable("id") long userId) {
        return donationService.getDonations(userId);
    }

    @PostMapping("/donate/{id}")
    @PreAuthorize("hasRole('DONOR')")
    public ResponseEntity<?> donate(@PathVariable("id") long userId, @RequestBody Donation donation) {
        return donationService.donate(userId, donation);
    }

    @PostMapping("/{id}/registerFor/{eventId}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<?> registerForEvent(@PathVariable("id") long userId, @PathVariable("eventId") long eventId) {
        return eventService.registerForEvent(userId, eventId);
    }

}
