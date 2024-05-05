package com.careerrbear.CareerBear.quiz.service;

import com.careerrbear.CareerBear.quiz.model.DetailedQuiz;
import com.careerrbear.CareerBear.quiz.model.QuizResults;
import com.careerrbear.CareerBear.quiz.model.interactions.BearInteraction;
import com.careerrbear.CareerBear.quiz.repository.DetailedQuizRepository;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QuizService {

    DetailedQuizRepository detailedQuizRepository;

    UserAccountRepository userAccountRepository;

    public QuizService(DetailedQuizRepository detailedQuizRepository, UserAccountRepository userAccountRepository) {
        this.detailedQuizRepository = detailedQuizRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public DetailedQuiz saveDetailedQuizData(DetailedQuiz detailedQuiz, Long userAccountId) {

        Optional<UserAccount> user = userAccountRepository.getUserAccountById(userAccountId);

        if (user.isEmpty()) {
            throw new RuntimeException("User Does Not Exist");
        }

        detailedQuiz.setDateTaken(LocalDate.now());
        detailedQuiz.setUserAccount(user.get());

//        detailedQuiz.getBearInteractions().forEach(bearInteraction -> {
//            bearInteraction.setDetailedQuiz(detailedQuiz);
//        });
        return detailedQuizRepository.save(detailedQuiz);
    }
}