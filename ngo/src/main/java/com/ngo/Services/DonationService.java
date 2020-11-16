package com.ngo.Services;

import com.ngo.Models.Donation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonationService {
    public ResponseEntity<List<Donation>> getAllDonations();
}
