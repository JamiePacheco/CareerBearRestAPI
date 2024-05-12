package com.careerrbear.CareerBear.quiz.model.BasicQuiz;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "BASIC_QUESTION")
public class BasicQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BASIC_QUESTION_ID")
    private Long basicQuestionId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUESTION_NUMBER")
    private Integer questionNumber;

    @Column(name = "ANSWER")
    private String answer;

}