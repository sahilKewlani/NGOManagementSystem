package com.ngo.Repository;

import com.ngo.Models.Event;
import com.ngo.Models.Role;
import com.ngo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findById(long id);
    Optional<Event> findByName(String name);
    Boolean existsByName(String name);
    List<Event> findByVolunteers(User user);
}