package com.ngo.Services;

import com.ngo.Models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<List<User>> getAllVolunteers();
    public ResponseEntity<List<User>> getAllDonors();
}
