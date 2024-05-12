package com.careerrbear.CareerBear.quiz.repository;

import com.careerrbear.CareerBear.quiz.model.DetailedQuiz.interactions.DetailedQuiz;
import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetailedQuizRepository extends JpaRepository<DetailedQuiz, Long> {

    Optional<List<DetailedQuiz>> getDetailedQuizsByUserAccount(UserAccount userAccount);



}
