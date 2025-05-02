package br.com.quiz.askanswer.adapters.out.persistence.impl;

import br.com.quiz.askanswer.adapters.out.persistence.entities.AskEntities;
import br.com.quiz.askanswer.adapters.out.persistence.entities.UserEntities;
import br.com.quiz.askanswer.adapters.out.persistence.repository.AskRepository;
import br.com.quiz.askanswer.adapters.out.persistence.repository.UserRepository;
import br.com.quiz.askanswer.domain.enums.CategoryEnum;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;
import br.com.quiz.askanswer.domain.repository.GeneratedQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GeneratedQuizImpl implements GeneratedQuiz {

    @Autowired
    private AskRepository askRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveAsk(AskDomain askDomain) {
        AskEntities askEntities = new AskEntities();
        askEntities.setIdAsk(UUID.randomUUID());
        askEntities.setEnunciated(askDomain.getEnunciated());
        askEntities.setCategoryEnum(CategoryEnum.getValue(askDomain.getCategory()));

        askRepository.save(askEntities);
    }

    @Override
    public void SaveUser(UserDomain userDomain) {
        UserEntities userEntities = new UserEntities();
        userEntities.setIdUser(UUID.randomUUID());
        userEntities.setUserName(userDomain.getUserName());
        userEntities.setBirthDate(userDomain.getBirthDate());
        userEntities.setHomeTown(userDomain.getHomeTown());

        userRepository.save(userEntities);
    }

    @Override
    public void createQuiz() {

    }
}
