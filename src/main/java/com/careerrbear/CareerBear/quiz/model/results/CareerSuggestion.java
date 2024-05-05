package com.careerrbear.CareerBear.quiz.model.results;

import com.careerrbear.CareerBear.quiz.model.QuizResults;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CAREER_SUGGESTION")
public class CareerSuggestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "CAREER")
    private String career;

    @Column(name = "CAREER_DESCRIPTION")
    private String careerDescription;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "QUIZ_RESULTS_ID")
//    private QuizResults quizResults;
}