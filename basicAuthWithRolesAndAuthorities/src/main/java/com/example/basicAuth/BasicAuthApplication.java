package com.example.basicAuth;

import com.example.basicAuth.entities.Usr;
import com.example.basicAuth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

import static com.example.basicAuth.config.security.UserRole.ADMIN;
import static com.example.basicAuth.config.security.UserRole.USER;

@SpringBootApplication
@RequiredArgsConstructor
public class BasicAuthApplication implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usr usr = new Usr("John", "Smith", passwordEncoder.encode("password"), "j", new HashSet<>(List.of(ADMIN, USER)));
        Usr usr2 = new Usr("Mattew", "Davidson", passwordEncoder.encode("password"), "m", new HashSet<>(List.of(USER)));
        Usr usr3 = new Usr("Clark", "Stevenson", passwordEncoder.encode("password"), "c", new HashSet<>(List.of(ADMIN)));
        userRepository.save(usr);
        userRepository.save(usr2);
        userRepository.save(usr3);
    }

}
