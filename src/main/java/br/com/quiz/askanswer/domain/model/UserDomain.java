package br.com.quiz.askanswer.domain.model;

import java.time.LocalDate;

public class UserDomain {
    private String userName;
    private LocalDate birthDate;
    private String homeTown;

    public UserDomain(String userName, LocalDate birthDate, String homeTown) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.homeTown = homeTown;
    }

    public UserDomain() {
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
}
