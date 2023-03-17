package com.example.jwtSecurity.services;

import com.example.jwtSecurity.dto.UserDto;
import com.example.jwtSecurity.entity.User;
import com.example.jwtSecurity.exceptions.UsernameAlreadyExistsException;
import com.example.jwtSecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jwtSecurity.entity.Role.USER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        try {
            User user = new User(List.of(USER), userDto.username(), userDto.password(), true, true, true, true);
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UsernameAlreadyExistsException(String.format("User with Username %s already exists.", userDto.username()));
        }
    }
}
