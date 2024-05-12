package com.careerrbear.CareerBear.quiz.model.DetailedQuiz.interactions;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "BEAR_INTERACTION")
public class BearInteraction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BEAR_INTERACTION_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CAREER_BEAR_ PROMPT_ID", referencedColumnName = "CAREER_BEAR_ PROMPT_ID")
    private CareerBearPrompt careerBearPrompt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_RESPONSE_ID", referencedColumnName = "USER_RESPONSE_ID")
    private UserResponse userResponse;

    @Column(name = "POSITION")
    private int position;
}