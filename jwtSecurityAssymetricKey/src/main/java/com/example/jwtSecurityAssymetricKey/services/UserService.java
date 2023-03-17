package com.example.jwtSecurityAssymetricKey.services;

import com.example.jwtSecurityAssymetricKey.dto.UserDto;
import com.example.jwtSecurityAssymetricKey.entities.User;

public interface UserService {

    User createUser(UserDto userDto);
}
