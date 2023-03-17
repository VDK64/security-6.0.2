package com.example.jwtSecurity;

import com.example.jwtSecurity.entity.Role;
import com.example.jwtSecurity.entity.User;
import com.example.jwtSecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtSecurityApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(List.of(Role.ADMIN), "admin", passwordEncoder.encode("p"), true, true, true, true);
        User user2 = new User(List.of(Role.USER), "user", passwordEncoder.encode("p"), true, true, true, true);
        userRepository.save(user1);
        userRepository.save(user2);
    }

}
