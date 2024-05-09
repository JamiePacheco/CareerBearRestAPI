package com.careerrbear.CareerBear.quiz.model.interactions;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_RESPONSE")
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_RESPONSE_ID")
    private Long userResponseId;

    @Column(name = "RESPONSE", length = 400)
    private String response;
}