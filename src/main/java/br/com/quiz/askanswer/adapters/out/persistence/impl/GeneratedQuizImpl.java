package br.com.quiz.askanswer.adapters.out.persistence.impl;

import br.com.quiz.askanswer.adapters.out.persistence.entities.AskEntities;
import br.com.quiz.askanswer.adapters.out.persistence.entities.QuizEntities;
import br.com.quiz.askanswer.adapters.out.persistence.entities.UserEntities;
import br.com.quiz.askanswer.adapters.out.persistence.repository.AskRepository;
import br.com.quiz.askanswer.adapters.out.persistence.repository.QuizRepository;
import br.com.quiz.askanswer.adapters.out.persistence.repository.UserRepository;
import br.com.quiz.askanswer.domain.enums.CategoryEnum;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;
import br.com.quiz.askanswer.domain.repository.GeneratedQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GeneratedQuizImpl implements GeneratedQuiz {

    @Autowired
    private AskRepository askRepository;

    @Autowired
    private QuizRepository quizRepository;

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
    public UserDomain getUser(UUID idUser) {
        return userRepository.findById(idUser).stream()
                .findFirst()
                .map(this::converterEntityUserToUserDomain)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar usuario"));
    }

    @Override
    public AskDomain getAsk(String category) {
        return askRepository.findByAskByCategory(category)
                .stream().findFirst()
                .map(this::converterEntityAskToAskDomain)
                .orElseThrow(() -> new RuntimeException("Erro ao buscar perguntas"));
    }

    @Override
    public List<String> getCategory() {
        return askRepository.findByAllCategory();
    }

    @Override
    public Boolean existsQuizByUser(UUID idUser) {
        return quizRepository.existsByUser(idUser);
    }


    @Override
    public List<QuizEntities> findByUserEntities(UUID idUser) {
        return quizRepository.findByUserEntitiesIdUser(idUser, Sort.by("quantityQuizGenerated").descending());
    }

    @Override
    public void createQuiz() {
    }

    private UserDomain converterEntityUserToUserDomain(UserEntities userEntities){
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userEntities.getUserName());
        userDomain.setBirthDate(userEntities.getBirthDate());
        userDomain.setHomeTown(userDomain.getHomeTown());
        return userDomain;
    }

    private AskDomain converterEntityAskToAskDomain(AskEntities askEntities){
        AskDomain askDomain = new AskDomain();
        askDomain.setCategory(askEntities.getCategoryEnum().getCategory());
        askDomain.setEnunciated(askEntities.getEnunciated());
        return askDomain;
    }
}
