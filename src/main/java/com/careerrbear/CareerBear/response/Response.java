package com.careerrbear.CareerBear.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@Builder
@AllArgsConstructor
public class Response<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";

    private String message;

    private String detailedMessage;

    private String status;

    private T responseContent;

}