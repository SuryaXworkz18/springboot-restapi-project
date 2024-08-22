package net.surya.springboot_restfullapi.service;

import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByID(Long userID);

    List<UserDto> getAllUser();
     UserDto updateUser(User user);

     void deleteUserById(Long useID);
}
