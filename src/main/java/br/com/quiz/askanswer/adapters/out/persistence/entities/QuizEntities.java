package br.com.quiz.askanswer.adapters.out.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_quiz")
public class QuizEntities implements Serializable {

    @Id
    private UUID idQuiz;

    private int quantityQuizGenerated;
    private String allAnswers;
    private int positionCorrectAnswer;

    @ManyToOne
    @JoinColumn(name = "idAsk")
    @JsonIgnore
    private AskEntities askEntities = new AskEntities();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntities userEntities = new UserEntities();

    public QuizEntities(UUID idQuiz, int quantityQuizGenerated, String allAnswers, int positionCorrectAnswer, AskEntities askEntities, UserEntities userEntities) {
        this.idQuiz = idQuiz;
        this.quantityQuizGenerated = quantityQuizGenerated;
        this.allAnswers = allAnswers;
        this.positionCorrectAnswer = positionCorrectAnswer;
        this.askEntities = askEntities;
        this.userEntities = userEntities;
    }

    public QuizEntities(){

    }

    public UUID getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(UUID idQuiz) {
        this.idQuiz = idQuiz;
    }

    public int getQuantityQuizGenerated() {
        return quantityQuizGenerated;
    }

    public void setQuantityQuizGenerated(int quantityQuizGenerated) {
        this.quantityQuizGenerated = quantityQuizGenerated;
    }

    public String getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(String allAnswers) {
        this.allAnswers = allAnswers;
    }

    public int getPositionCorrectAnswer() {
        return positionCorrectAnswer;
    }

    public void setPositionCorrectAnswer(int positionCorrectAnswer) {
        this.positionCorrectAnswer = positionCorrectAnswer;
    }

    public AskEntities getAskEntities() {
        return askEntities;
    }

    public void setAskEntities(AskEntities askEntities) {
        this.askEntities = askEntities;
    }

    public UserEntities getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntities userEntities) {
        this.userEntities = userEntities;
    }
}
