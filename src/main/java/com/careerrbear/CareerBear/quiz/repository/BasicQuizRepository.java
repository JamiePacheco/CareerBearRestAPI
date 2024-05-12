package com.careerrbear.CareerBear.quiz.repository;

import com.careerrbear.CareerBear.quiz.model.BasicQuiz.BasicQuiz;
import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasicQuizRepository extends JpaRepository<BasicQuiz, Long> {

    Optional<List<BasicQuiz>> getBasicQuizByUser(UserAccount userAccount);

}
