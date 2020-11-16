package com.ngo.Services;

import com.ngo.Models.Donation;
import com.ngo.Models.Event;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonationService {
    public ResponseEntity<List<Donation>> getAllDonations();
    public ResponseEntity<List<Donation>> getDonations(long userId);
    public ResponseEntity<?> donate(long userId, Donation donation);
}
