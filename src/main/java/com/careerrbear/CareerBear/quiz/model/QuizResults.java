package com.careerrbear.CareerBear.quiz.model;

import com.careerrbear.CareerBear.quiz.model.results.CareerSuggestion;
import com.careerrbear.CareerBear.quiz.model.results.PersonalityTrait;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "QUIZ_RESULTS")
public class QuizResults implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "QUIZ_RESULTS_ID")
    private Long quizResultsId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PersonalityTrait> personalityTraits;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CareerSuggestion> careerSuggestions;

//    @OneToOne(mappedBy = "quizResults", cascade = CascadeType.ALL)
//    private DetailedQuiz detailedQuiz;
}
