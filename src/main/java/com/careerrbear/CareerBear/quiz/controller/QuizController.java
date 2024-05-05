package com.careerrbear.CareerBear.quiz.controller;

import com.careerrbear.CareerBear.quiz.model.DetailedQuiz;
import com.careerrbear.CareerBear.quiz.model.QuizResults;
import com.careerrbear.CareerBear.quiz.service.QuizService;
import com.careerrbear.CareerBear.user.model.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/save-quiz-data")
    public ResponseEntity<DetailedQuiz> saveDetailedQuiz(@RequestParam(name = "userId") Long userAccountId, @RequestBody DetailedQuiz detailedQuiz) {
        return ResponseEntity.ok(quizService.saveDetailedQuizData(detailedQuiz, userAccountId));
    }

    @GetMapping("/get-quiz-data")
    public ResponseEntity<List<DetailedQuiz>> getDetailedQuizData(@RequestParam(name = "userId") Long userAccountId) {
        return ResponseEntity.ok(quizService.getDetailedQuizData(userAccountId));
    }

}
