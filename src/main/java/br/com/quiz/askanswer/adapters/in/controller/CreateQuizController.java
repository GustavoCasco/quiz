package br.com.quiz.askanswer.adapters.in.controller;

import br.com.quiz.askanswer.application.usecase.GeneratedQuizUC;
import br.com.quiz.askanswer.domain.model.QuizGenerateDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateQuizController {

    @Autowired
    private GeneratedQuizUC generatedQuiz;

    @GetMapping("/create-quiz/{idUser}")
    private ResponseEntity<List<QuizGenerateDomain>> generatedAskAndAnswer(@PathVariable String idUser){
        return ResponseEntity.ok(generatedQuiz.createQuiz(idUser));
    }
}
