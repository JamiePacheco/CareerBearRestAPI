package com.careerrbear.CareerBear.quiz.controller;

import com.careerrbear.CareerBear.quiz.model.BasicQuiz.BasicQuiz;
import com.careerrbear.CareerBear.quiz.model.DetailedQuiz.interactions.DetailedQuiz;
import com.careerrbear.CareerBear.quiz.service.QuizService;
import com.careerrbear.CareerBear.response.Response;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Response<DetailedQuiz>> saveDetailedQuiz(@RequestParam(name = "userId") Long userAccountId, @RequestBody DetailedQuiz detailedQuiz) {
        try {
            DetailedQuiz savedDetailedQuiz = quizService.saveDetailedQuizData(detailedQuiz, userAccountId);
            return ResponseEntity.ok(
                    Response.<DetailedQuiz>builder()
                            .message("Saved detailed quiz")
                            .detailedMessage("Saved detailed quiz to user account")
                            .status(Response.SUCCESS)
                            .responseContent(savedDetailedQuiz)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<DetailedQuiz>builder()
                            .message("Issue saving detailed quiz data to user account")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }

    @PostMapping("save-basic-quiz-data")
    public ResponseEntity<Response<BasicQuiz>> saveBasicQuiz(@RequestParam(name = "userId") Long userAccountId, @RequestBody BasicQuiz basicQuiz) {
        try {
            BasicQuiz savedBasicQuiz = quizService.saveBasicQuizData(basicQuiz, userAccountId);
            return ResponseEntity.ok(
                    Response.<BasicQuiz>builder()
                            .message("Saved Basic Quiz")
                            .detailedMessage("Saved basic quiz to user account")
                            .status(Response.SUCCESS)
                            .responseContent(savedBasicQuiz)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<BasicQuiz>builder()
                            .message("Issue saving basic quiz data to user account")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }

    @GetMapping("/get-quiz-data")
    public ResponseEntity<Response<List<DetailedQuiz>>> getDetailedQuizData(@RequestParam(name = "userId") Long userAccountId) {
        try {
            List<DetailedQuiz> savedDetailedQuiz = quizService.getDetailedQuizData(userAccountId);
            return ResponseEntity.ok(
                    Response.<List<DetailedQuiz>>builder()
                            .message("Got detailed quiz data")
                            .detailedMessage("Got detailed quiz data for logged user")
                            .status(Response.SUCCESS)
                            .responseContent(savedDetailedQuiz)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<List<DetailedQuiz>>builder()
                            .message("Issue getting detailed quiz data for user")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }
    @GetMapping("/get-basic-quiz-data")
    public ResponseEntity<Response<List<BasicQuiz>>> getBasicQuizData(@RequestParam(name = "userId") Long userAccountId) {
        try {
            List<BasicQuiz> savedDetailedQuiz = quizService.getBasicQuizData(userAccountId);
            return ResponseEntity.ok(
                    Response.<List<BasicQuiz>>builder()
                            .message("Got basic quiz data")
                            .detailedMessage("Got basic quiz data for logged user")
                            .status(Response.SUCCESS)
                            .responseContent(savedDetailedQuiz)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<List<BasicQuiz>>builder()
                            .message("Issue getting basic quiz data for user")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }


    @PostMapping("/delete-quiz-data")
    public ResponseEntity<Response<String>> deleteDetailedQuizData(@RequestParam(name = "quizId") Long detailedQuizId) {
        try {
            quizService.deleteDetailedQuizData(detailedQuizId);
            return ResponseEntity.ok(
                    Response.<String>builder()
                            .message("Deleted detailed quiz data")
                            .detailedMessage("Detailed quiz has been successfully deleted")
                            .status(Response.SUCCESS)
                            .responseContent("YIPPIE!!!")
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<String>builder()
                            .message("Issue deleting detailed quiz data")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }
    @PostMapping("/delete-basic-quiz-data")
    public ResponseEntity<Response<String>> deleteBasicQuiz(@RequestParam(name = "quizId") Long basicQuizId) {
        try {
            quizService.deleteBasicQuizData(basicQuizId);
            return ResponseEntity.ok(
                    Response.<String>builder()
                            .message("Deleted basic quiz data")
                            .detailedMessage("Basic quiz has been successfully deleted")
                            .status(Response.SUCCESS)
                            .responseContent("YIPPIE!!!")
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.<String>builder()
                            .message("Issue deleting basic quiz data")
                            .detailedMessage(e.getMessage())
                            .status(Response.FAILURE)
                            .responseContent(null)
                            .build()
            );
        }
    }


}
