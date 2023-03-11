package com.example.basicAuth.services;

import com.example.basicAuth.dto.UserDto;
import com.example.basicAuth.entities.Usr;
import com.example.basicAuth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        Usr usr = new Usr(userDto.firstname(), userDto.lastname(), passwordEncoder.encode(userDto.password()),
                userDto.username(), userDto.roles());
        userRepository.save(usr);
    }
}
