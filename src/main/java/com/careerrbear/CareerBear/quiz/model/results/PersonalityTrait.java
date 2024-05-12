package com.careerrbear.CareerBear.quiz.model.results;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "PERSONALITY_TRAIT")
public class PersonalityTrait implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PERSONALITY_TRAIT_ID")
    private Long id;

    @Column(name = "TRAIT")
    private String trait;

    @Column(name = "TRAIT_DESCRIPTION", length = 400)
    private String traitDescription;

    @Column(name = "TRAIT_LOGIC", length = 400)
    private String traitLogic;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "QUIZ_RESULTS_ID", referencedColumnName = "QUIZ_RESULTS_ID")
//    private QuizResults quizResults;
}
