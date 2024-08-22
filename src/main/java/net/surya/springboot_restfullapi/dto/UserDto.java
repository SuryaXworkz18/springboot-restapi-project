package net.surya.springboot_restfullapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private  Long id;
    @NotEmpty(message = "User firstname should not be null or empty ")
    private String firstName;
    @NotEmpty(message = "User lastname should not be null or empty ")
    private String lastName;
    @NotEmpty(message = "User email should not be null or empty ")
    @Email(message = "User email should be valid")
    private String email;


}
