package com.ngo.Services;

import com.ngo.Models.ERole;
import com.ngo.Models.Role;
import com.ngo.Models.User;
import com.ngo.Repository.RoleRepository;
import com.ngo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity<List<User>> getAllVolunteers(){
        try {
            List<User> users = new ArrayList<User>();

            Role userRole = roleRepository.findByName(ERole.ROLE_VOLUNTEER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userRepository.findAllByRoles(userRole).forEach(users::add);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllDonors(){
        try {
            List<User> users = new ArrayList<User>();

            Role userRole = roleRepository.findByName(ERole.ROLE_DONOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userRepository.findAllByRoles(userRole).forEach(users::add);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
