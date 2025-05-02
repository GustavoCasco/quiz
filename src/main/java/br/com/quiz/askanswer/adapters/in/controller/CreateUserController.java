package br.com.quiz.askanswer.adapters.in.controller;

import br.com.quiz.askanswer.adapters.in.dto.CreateUserDTO;
import br.com.quiz.askanswer.application.usecase.GeneratedQuizUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    @Autowired
    private GeneratedQuizUC generatedQuiz;

    @PostMapping("/create-user")
    private ResponseEntity<String> createUser (@RequestBody CreateUserDTO userDTO){
        generatedQuiz.SaveUser(userDTO);
        return ResponseEntity.ok("Ok");
    }

}
