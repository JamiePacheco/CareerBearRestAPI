package com.careerrbear.CareerBear.quiz.model.BasicQuiz;


import com.careerrbear.CareerBear.quiz.model.results.CareerFieldSuggestion;
import com.careerrbear.CareerBear.quiz.model.results.PersonalityTrait;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "BASIC_QUIZ_RESULT")
public class BasicQuizResults implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BASIC_QUESTION_RESULT_ID")
    private Long basicQuizResultsId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PersonalityTrait> personalityTraits;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CareerFieldSuggestion> careerFieldSuggestions;
}