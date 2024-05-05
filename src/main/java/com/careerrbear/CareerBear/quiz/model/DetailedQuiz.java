package com.careerrbear.CareerBear.quiz.model;

import com.careerrbear.CareerBear.quiz.model.interactions.BearInteraction;
import com.careerrbear.CareerBear.user.model.UserAccount;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "DETAILED_QUIZ")
public class DetailedQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DETAILED_QUIZ_ID")
    private Long detailedQuizId;

    @Column(name = "DATE_TAKEN")
    private LocalDate dateTaken;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BearInteraction> bearInteractions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_RESULTS_ID", referencedColumnName = "QUIZ_RESULTS_ID")
    private QuizResults quizResults;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ACCOUNT_ID")
    private UserAccount userAccount;
}
