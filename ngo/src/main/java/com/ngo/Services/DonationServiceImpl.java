package com.ngo.Services;

import com.ngo.Models.Donation;
import com.ngo.Models.ERole;
import com.ngo.Models.Role;
import com.ngo.Models.User;
import com.ngo.Repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DonationServiceImpl implements DonationService{

    @Autowired
    DonationRepository donationRepository;

    @Override
    public ResponseEntity<List<Donation>> getAllDonations() {
        try {
            List<Donation> donations = new ArrayList<Donation>();

            donationRepository.findAll().forEach(donations::add);

            if (donations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(donations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
