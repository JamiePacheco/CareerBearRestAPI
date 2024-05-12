package com.careerrbear.CareerBear.quiz.service;

import com.careerrbear.CareerBear.exceptions.quizExceptions.DetailedQuizException;
import com.careerrbear.CareerBear.quiz.model.BasicQuiz.BasicQuiz;
import com.careerrbear.CareerBear.quiz.model.DetailedQuiz.interactions.DetailedQuiz;
import com.careerrbear.CareerBear.quiz.repository.BasicQuizRepository;
import com.careerrbear.CareerBear.quiz.repository.DetailedQuizRepository;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    DetailedQuizRepository detailedQuizRepository;

    BasicQuizRepository basicQuizRepository;

    UserAccountRepository userAccountRepository;

    public QuizService(
            DetailedQuizRepository detailedQuizRepository,
            UserAccountRepository userAccountRepository,
            BasicQuizRepository basicQuizRepository
    ) {
        this.detailedQuizRepository = detailedQuizRepository;
        this.basicQuizRepository = basicQuizRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public DetailedQuiz saveDetailedQuizData(DetailedQuiz detailedQuiz, Long userAccountId) {

        Optional<UserAccount> user = userAccountRepository.getUserAccountById(userAccountId);

        if (user.isEmpty()) {
            throw new RuntimeException("User Does Not Exist");
        }

        detailedQuiz.setDateTaken(LocalDate.now());
        detailedQuiz.setUserAccount(user.get());

        return detailedQuizRepository.save(detailedQuiz);
    }

    public BasicQuiz saveBasicQuizData(BasicQuiz basicQuiz, Long userAccountId) {

        Optional<UserAccount> user = userAccountRepository.getUserAccountById(userAccountId);

        if (user.isEmpty()) {
            throw new RuntimeException("User Does Not Exist");
        }

        basicQuiz.setDateTaken(LocalDateTime.now());
        basicQuiz.setUser(user.get());

        return basicQuizRepository.save(basicQuiz);
    }

    public List<DetailedQuiz> getDetailedQuizData(Long userAccountId) {
        Optional<UserAccount> userAccount = userAccountRepository.getUserAccountById(userAccountId);

        if (userAccount.isEmpty()) {
            throw new DetailedQuizException("Error getting data: Account does not exist");
        }

        return detailedQuizRepository.getDetailedQuizsByUserAccount(userAccount.get()).get();
    }

    public List<BasicQuiz> getBasicQuizData(Long userAccountId) {
        Optional<UserAccount> userAccount = userAccountRepository.getUserAccountById(userAccountId);

        if (userAccount.isEmpty()) {
            throw new DetailedQuizException("Error getting data: Account does not exist");
        }

        return basicQuizRepository.getBasicQuizByUser(userAccount.get()).get();
    }

    public void deleteDetailedQuizData(Long detailedQuizId) {
        detailedQuizRepository.deleteById(detailedQuizId);
    }

    public void deleteBasicQuizData(Long basicQuizId) {basicQuizRepository.deleteById(basicQuizId);}

}