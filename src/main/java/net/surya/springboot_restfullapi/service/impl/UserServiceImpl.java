package net.surya.springboot_restfullapi.service.impl;

import lombok.AllArgsConstructor;
import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;
import net.surya.springboot_restfullapi.exceptionHandlling.EmailAlreadyExited;
import net.surya.springboot_restfullapi.exceptionHandlling.ResourceNotFoundException;
import net.surya.springboot_restfullapi.mapper.AutoUserMapper;
import net.surya.springboot_restfullapi.mapper.UserMapper;
import net.surya.springboot_restfullapi.repository.UserRepo;
import net.surya.springboot_restfullapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
//Conver dto into jpa entity
       // User user =UserMapper.maptoUser(userDto);
//        User user = modelMapper.map(userDto,User.class);  This is using modelmapping

        Optional<User> optionalUser = userRepo.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExited("Email Already existed for user ");

        }
        //this is modelstruct mapping
        User user = AutoUserMapper.MAPPER.maptoUser(userDto);


        User savedUser = userRepo.save(user);

        //UserDto savedUserDto = UserMapper.maptoUseDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.maptoUserDto(savedUser);
        return savedUserDto;

    }

    @Override
    public UserDto getUserByID(Long userID) {
       User user = userRepo.findById(userID).orElseThrow(
               () -> new ResourceNotFoundException("user","id",userID)
       );
//       return  UserMapper.maptoUseDto(user);
//        return  modelMapper.map(user,UserDto.class);
        return  AutoUserMapper.MAPPER.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users = userRepo.findAll();
//        return user.stream().map(UserMapper::maptoUseDto).collect(Collectors.toList());
//        return user.stream().map((user1 -> modelMapper.map(user,UserDto.class))).collect(Collectors.toList());
        return users.stream().map((user -> AutoUserMapper.MAPPER.maptoUserDto(user))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(User user) {
        User exitingUser = userRepo.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("user","id", user.getId())
        );
        exitingUser.setFirstName(user.getFirstName());
        exitingUser.setLastName(user.getLastName());
        exitingUser.setEmail(user.getEmail());
        User updatedUser = userRepo.save(exitingUser);
//        return UserMapper.maptoUseDto(updatedUser);
//        return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long useID) {
        User exitingUser = userRepo.findById(useID).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", useID));
        userRepo.deleteById(useID);
    }


}
