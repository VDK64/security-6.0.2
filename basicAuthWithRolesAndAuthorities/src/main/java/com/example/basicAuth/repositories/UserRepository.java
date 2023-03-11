package com.example.basicAuth.repositories;

import com.example.basicAuth.entities.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {

    Optional<UserDetails> findByUsername(String username);

}
