package br.com.quiz.askanswer.domain.model;

import br.com.quiz.askanswer.adapters.out.persistence.entities.AskEntities;
import br.com.quiz.askanswer.adapters.out.persistence.entities.UserEntities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class QuizGenerateDomain {

    private String ask;
    private List<String> allAnswers;
    private int quantityQuizGenerated;
    private int positionCorrectAnswer;
    @JsonIgnore
    private UserEntities userEntities = new UserEntities();
    @JsonIgnore
    private AskEntities askEntities = new AskEntities();

    public QuizGenerateDomain() {
    }

    public QuizGenerateDomain(List<String> allAnswers, String ask, int quantityQuizGenerated, int positionCorrectAnswer, UserEntities userEntities, AskEntities askEntities) {
        this.allAnswers = allAnswers;
        this.ask = ask;
        this.quantityQuizGenerated = quantityQuizGenerated;
        this.positionCorrectAnswer = positionCorrectAnswer;
        this.userEntities = userEntities;
        this.askEntities = askEntities;
    }

    public List<String> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(List<String> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public int getQuantityQuizGenerated() {
        return quantityQuizGenerated;
    }

    public void setQuantityQuizGenerated(int quantityQuizGenerated) {
        this.quantityQuizGenerated = quantityQuizGenerated;
    }

    public int getPositionCorrectAnswer() {
        return positionCorrectAnswer;
    }

    public void setPositionCorrectAnswer(int positionCorrectAnswer) {
        this.positionCorrectAnswer = positionCorrectAnswer;
    }

    public UserEntities getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntities userEntities) {
        this.userEntities = userEntities;
    }

    public AskEntities getAskEntities() {
        return askEntities;
    }

    public void setAskEntities(AskEntities askEntities) {
        this.askEntities = askEntities;
    }
}
