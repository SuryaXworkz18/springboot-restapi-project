package net.surya.springboot_restfullapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;
import net.surya.springboot_restfullapi.exceptionHandlling.ErrorDetails;
import net.surya.springboot_restfullapi.exceptionHandlling.ResourceNotFoundException;
import net.surya.springboot_restfullapi.repository.UserRepo;
import net.surya.springboot_restfullapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping ("api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUSer(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long useId){
        UserDto user = userService.getUserByID(useId);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getALlUser(){
        List<UserDto> user = userService.getAllUser();
         return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long userID,@RequestBody User user){
        user.setId(userID);
         UserDto updatedUser = userService.updateUser(user);
         return  new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userID){
        userService.deleteUserById(userID);
        return new ResponseEntity<>("User Deleted Successfully!",HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
//
//    }

}
