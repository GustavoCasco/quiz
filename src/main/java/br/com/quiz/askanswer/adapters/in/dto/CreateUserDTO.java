package br.com.quiz.askanswer.adapters.in.dto;

import java.time.LocalDate;

public class CreateUserDTO {

    private String userName;
    private LocalDate birthDate;
    private String homeTown;

    public CreateUserDTO(String userName, LocalDate birthDate, String homeTown) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.homeTown = homeTown;
    }

    public CreateUserDTO() {
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
