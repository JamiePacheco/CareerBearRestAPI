package com.careerrbear.CareerBear.exceptions.userExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class SignUpException extends RuntimeException{

    public SignUpException(String message) {
        super(message);
    }

}
