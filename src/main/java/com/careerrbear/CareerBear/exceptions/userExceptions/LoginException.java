package com.careerrbear.CareerBear.exceptions.userExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class LoginException extends RuntimeException{

    public LoginException(String message) {
        super(message);
    }

}
