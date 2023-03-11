package com.example.basicAuth.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    Optional<UserDetails> findByUsername(String username);

}
