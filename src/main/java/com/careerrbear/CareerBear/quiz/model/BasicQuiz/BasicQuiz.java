package com.careerrbear.CareerBear.quiz.model.BasicQuiz;

import com.careerrbear.CareerBear.user.model.UserAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "BASIC_QUIZ")
public class BasicQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BASIC_QUIZ_RESULTS")
    private Long basicQuizResultsId;

    @Column(name = "DATE TAKEN")
    private LocalDateTime dateTaken;

    @Column(name = "CURRENT_QUESTION")
    private Integer currentQuestion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BasicQuestion> questionList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BASIC_QUESTION_RESULT_ID")
    private BasicQuizResults basicQuizResults;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ACCOUNT_ID")
    @JsonProperty(namespace = "userId")
    private UserAccount user;

}
