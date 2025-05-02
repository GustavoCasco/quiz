package br.com.quiz.askanswer.application.usecase;

import br.com.quiz.askanswer.adapters.in.dto.CreateAskDTO;
import br.com.quiz.askanswer.adapters.in.dto.CreateUserDTO;
import br.com.quiz.askanswer.adapters.out.persistence.impl.GeneratedQuizImpl;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneratedQuizUC {

    @Autowired
    private GeneratedQuizImpl generatedQuiz;

    public void saveAsk(CreateAskDTO askDTO) {
        AskDomain askDomain = new AskDomain();
        askDomain.setCategory(askDomain.getCategory());
        askDomain.setEnunciated(askDomain.getEnunciated());
        generatedQuiz.saveAsk(askDomain);
    }

    public void SaveUser(CreateUserDTO userDTO) {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userDTO.getUserName());
        userDomain.setBirthDate(userDTO.getBirthDate());
        userDomain.setHomeTown(userDTO.getHomeTown());

        generatedQuiz.SaveUser(userDomain);
    }

    public void createQuiz() {

    }
}
