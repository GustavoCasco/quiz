package br.com.quiz.askanswer.adapters.in.controller;

import br.com.quiz.askanswer.adapters.in.dto.CreateAskDTO;
import br.com.quiz.askanswer.application.usecase.GeneratedQuizUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAskController {

    @Autowired
    private GeneratedQuizUC generatedQuiz;

    @PostMapping("/create-ask")
    private ResponseEntity<String> generatedAskAndAnswer(@RequestBody CreateAskDTO askDTO){
        generatedQuiz.saveAsk(askDTO);
        return ResponseEntity.ok("Ok");
    }
}
