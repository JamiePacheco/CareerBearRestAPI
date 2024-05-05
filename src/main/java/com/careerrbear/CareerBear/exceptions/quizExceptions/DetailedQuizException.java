package com.careerrbear.CareerBear.exceptions.quizExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DetailedQuizException extends RuntimeException{

    public DetailedQuizException(String message) {
        super(message);
    }

}
