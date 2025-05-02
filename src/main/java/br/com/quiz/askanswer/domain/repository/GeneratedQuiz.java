package br.com.quiz.askanswer.domain.repository;

import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;

public interface GeneratedQuiz {

    void saveAsk(AskDomain askDomain);
    void SaveUser(UserDomain userDomain);

    void createQuiz();


}
