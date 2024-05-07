package com.careerrbear.CareerBear.quiz.model.interactions;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CAREER_BEAR_PROMPT")
public class CareerBearPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CAREER_BEAR_ PROMPT_ID")
    private Long id;

    @Column(name = "PROMPT", length = 400)
    private String prompt;
}
