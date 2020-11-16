package com.ngo.Repository;

import com.ngo.Models.Donation;
import com.ngo.Models.ERole;
import com.ngo.Models.Role;
import com.ngo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    Optional<Donation> findByTransactionId(String transactionId);
    Boolean existsByTransactionId(String transactionId);
    List<Donation> findByDonor(User donor);
}
