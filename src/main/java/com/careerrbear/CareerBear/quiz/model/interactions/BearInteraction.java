package com.careerrbear.CareerBear.quiz.model.interactions;

import com.careerrbear.CareerBear.quiz.model.DetailedQuiz;
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

    @Column(name = "CAREER_BEAR_PROMPT", length = 500)
    private String careerBearPrompt;

    @Column(name = "USER_RESPONSE")
    private String userResponse;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "DETAILED_QUIZ_ID", nullable = false)
//    private DetailedQuiz detailedQuiz;
}