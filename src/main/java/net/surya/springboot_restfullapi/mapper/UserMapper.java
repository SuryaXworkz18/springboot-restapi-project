package net.surya.springboot_restfullapi.mapper;

import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;

public class UserMapper {

    public  static UserDto maptoUseDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

  return  userDto;
    }
    public static User maptoUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return  user;
    }
}
