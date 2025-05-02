package br.com.quiz.askanswer.adapters.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_usuario")
public class UserEntities implements Serializable  {

    @Id
    private UUID idUser;
    private String userName;
    private LocalDate birthDate;
    private String homeTown;

    @OneToOne(mappedBy = "userEntities")
    private QuizEntities quizEntities;

    public UserEntities(UUID idUser, String userName, LocalDate birthDate, String homeTown, QuizEntities quizEntities) {
        this.idUser = idUser;
        this.userName = userName;
        this.birthDate = birthDate;
        this.homeTown = homeTown;
        this.quizEntities = quizEntities;
    }

    public UserEntities(){

    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public QuizEntities getQuizEntities() {
        return quizEntities;
    }

    public void setQuizEntities(QuizEntities quizEntities) {
        this.quizEntities = quizEntities;
    }
}
