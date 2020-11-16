package com.ngo.Services;

import com.ngo.Models.*;
import com.ngo.Payload.Response.MessageResponse;
import com.ngo.Repository.DonationRepository;
import com.ngo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DonationServiceImpl implements DonationService{

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    UserRepository userRepository;

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

    @Override
    public ResponseEntity<List<Donation>> getDonations(long userId){
        try {
            List<Donation> donations = new ArrayList<Donation>();

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));
            donationRepository.findByDonor(user).forEach(donations::add);

            if (donations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(donations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> donate(long userId, Donation donation){
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));
            Donation donationObj = new Donation();
            donationObj.setAmount(donation.getAmount());
            donationObj.setDate(new Date());
            donationObj.setDonor(user);
            Donation _donation = donationRepository
                    .save(donationObj);
            return ResponseEntity.ok(new MessageResponse("Donation successful!"));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
