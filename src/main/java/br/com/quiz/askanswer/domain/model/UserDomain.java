package br.com.quiz.askanswer.domain.model;

import java.time.LocalDate;

public class UserDomain {
    private String userName;
    private LocalDate birthDate;
    private String homeTown;
    private QuizGenerateDomain quizGenerateDomain;
    private AskDomain askDomain;

    public UserDomain(String userName, LocalDate birthDate, String homeTown, QuizGenerateDomain quizGenerateDomain,
                      AskDomain askDomain) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.homeTown = homeTown;
        this.quizGenerateDomain = quizGenerateDomain;
        this.askDomain = askDomain;
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

    public QuizGenerateDomain getQuizGenerateDomain() {
        return quizGenerateDomain;
    }

    public void setQuizGenerateDomain(QuizGenerateDomain quizGenerateDomain) {
        this.quizGenerateDomain = quizGenerateDomain;
    }

    public AskDomain getAskDomain() {
        return askDomain;
    }

    public void setAskDomain(AskDomain askDomain) {
        this.askDomain = askDomain;
    }
}
