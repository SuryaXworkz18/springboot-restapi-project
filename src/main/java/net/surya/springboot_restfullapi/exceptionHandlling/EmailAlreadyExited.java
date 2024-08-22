package net.surya.springboot_restfullapi.exceptionHandlling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExited extends  RuntimeException {
    private String message;

    public EmailAlreadyExited(String message){
        super(message);
    }
}
