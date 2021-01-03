package com.ngo.Repository;

import java.util.Optional;

import com.ngo.Models.ERole;
import com.ngo.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface
RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
