package br.com.quiz.askanswer.domain.repository;

import br.com.quiz.askanswer.adapters.out.persistence.entities.QuizEntities;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;

import java.util.List;
import java.util.UUID;

public interface GeneratedQuiz {

    void saveAsk(AskDomain askDomain);
    void SaveUser(UserDomain userDomain);
    UserDomain getUser(UUID idUser);
    AskDomain getAsk(String category);
    List<String> getCategory();
    Boolean existsQuizByUser(UUID idUser);
    List<QuizEntities> findByUserEntities(UUID idUser);
    void createQuiz();

}
