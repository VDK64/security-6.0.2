package com.example.jwtSecurityAssymetricKey.services.impl;

import com.example.jwtSecurityAssymetricKey.dto.UserDto;
import com.example.jwtSecurityAssymetricKey.entities.User;
import com.example.jwtSecurityAssymetricKey.repositories.UserRepository;
import com.example.jwtSecurityAssymetricKey.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.jwtSecurityAssymetricKey.permissions.Role.ADMIN;
import static com.example.jwtSecurityAssymetricKey.permissions.Role.USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto.username(), passwordEncoder.encode(userDto.password()));
        if (userDto.admin()) {
            user.setRoles(List.of(ADMIN));
        } else {
            user.setRoles(List.of(USER));
        }
        return userRepository.save(user);
    }

}
