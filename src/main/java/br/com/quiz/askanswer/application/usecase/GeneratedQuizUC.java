package br.com.quiz.askanswer.application.usecase;

import br.com.quiz.askanswer.adapters.in.dto.CreateAskDTO;
import br.com.quiz.askanswer.adapters.in.dto.CreateUserDTO;
import br.com.quiz.askanswer.adapters.out.persistence.impl.GeneratedQuizImpl;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.QuizGenerateDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class GeneratedQuizUC {

    @Autowired
    private GeneratedQuizImpl generatedQuiz;

    public void saveAsk(CreateAskDTO askDTO) {
        AskDomain askDomain = new AskDomain();
        askDomain.setCategory(askDTO.getCategory());
        askDomain.setEnunciated(askDTO.getEnunciated());
        generatedQuiz.saveAsk(askDomain);
        createQuiz();
    }

    public void SaveUser(CreateUserDTO userDTO) {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userDTO.getUserName());
        userDomain.setBirthDate(userDTO.getBirthDate());
        userDomain.setHomeTown(userDTO.getHomeTown());

        generatedQuiz.SaveUser(userDomain);
    }

    public void createQuiz() {
        AtomicInteger sequenceAllQuizByUser = new AtomicInteger(0);
        UserDomain userDomain =  generatedQuiz.getUser(UUID.fromString("41a74115-cf10-4e8c-9b9e-74597a73fa48"));
        List<QuizGenerateDomain> listQuizGenerateDomain = new ArrayList<>();
        List<String> allCategory = generatedQuiz.getCategory();

        var hasQuizByUser = generatedQuiz.
                existsQuizByUser(UUID.fromString("41a74115-cf10-4e8c-9b9e-74597a73fa48"));

        if(hasQuizByUser){
            sequenceAllQuizByUser.set(generatedQuiz.findByUserEntities(UUID.fromString("41a74115-cf10-4e8c-9b9e-74597a73fa48"))
                    .getFirst().getQuantityQuizGenerated());

            if (sequenceAllQuizByUser.get() > 3) {
                throw new RuntimeException("Usuario Bloqueado, reset seu usuario para gerar perguntas novas");
            }

            sequenceAllQuizByUser.set(sequenceAllQuizByUser.get() + 1);
        }else {
            sequenceAllQuizByUser.set(1);
        }

        allCategory.forEach(x -> {
            QuizGenerateDomain quizGenerateDomain = new QuizGenerateDomain();
            for (int i = 0; i < 1; i++) {
                AskDomain askDomain = generatedQuiz.getAsk(x);
                quizGenerateDomain.setAsk(askDomain.getEnunciated());
            }
            quizGenerateDomain.setQuantityQuizGenerated(sequenceAllQuizByUser.get());
            listQuizGenerateDomain.add(quizGenerateDomain);
        });

    }

    private String getAnswerCorrect(UserDomain userDomain, String category){
        return switch (category){
            case "Local Nascimento" -> userDomain.getHomeTown();
            case "Data Nascimento" -> userDomain.getBirthDate().toString();
            case "Nome"  -> userDomain.getUserName();

            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }
}
