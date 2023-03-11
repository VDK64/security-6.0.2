package com.example.basicAuth;

import com.example.basicAuth.config.security.UserRole;
import com.example.basicAuth.entities.Usr;
import com.example.basicAuth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

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
        Usr usr = new Usr("John", "Smith", passwordEncoder.encode("password"), "smitty", new HashSet<>(Arrays.asList(UserRole.ADMIN)));
        userRepository.save(usr);
        UserDetails smitty = userRepository.findByUsername("smitty").orElseThrow();
        System.out.println();

    }
}
