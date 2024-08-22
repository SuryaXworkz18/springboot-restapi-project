package net.surya.springboot_restfullapi.mapper;

import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //if the feild name are differnce
   // @Mapping(source = "email",target = "emailAddress")
    UserDto maptoUserDto(User user);
    User maptoUser(UserDto userDto);

}
