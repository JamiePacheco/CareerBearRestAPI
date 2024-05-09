package com.careerrbear.CareerBear.quiz.model;

import com.careerrbear.CareerBear.quiz.model.interactions.BearInteraction;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "DETAILED_QUIZ")
public class DetailedQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DETAILED_QUIZ_ID")
    @JsonProperty(namespace = "id")
    private Long detailedQuizId;

    @Column(name = "DATE_TAKEN")
    private LocalDate dateTaken;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty(namespace = "interactions")
    private Set<BearInteraction> bearInteractions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_RESULTS_ID", referencedColumnName = "QUIZ_RESULTS_ID")
    @JsonProperty(namespace = "results")
    private QuizResults quizResults;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ACCOUNT_ID")
    @JsonProperty(namespace = "userId")
    private UserAccount userAccount;
}
