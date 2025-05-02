package br.com.quiz.askanswer.application.usecase;

import br.com.quiz.askanswer.adapters.in.dto.CreateAskDTO;
import br.com.quiz.askanswer.adapters.in.dto.CreateUserDTO;
import br.com.quiz.askanswer.adapters.out.persistence.impl.GeneratedQuizImpl;
import br.com.quiz.askanswer.domain.model.AskDomain;
import br.com.quiz.askanswer.domain.model.QuizGenerateDomain;
import br.com.quiz.askanswer.domain.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    }

    public void SaveUser(CreateUserDTO userDTO) {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userDTO.getUserName());
        userDomain.setBirthDate(userDTO.getBirthDate());
        userDomain.setHomeTown(userDTO.getHomeTown());

        generatedQuiz.SaveUser(userDomain);
    }

    public List<QuizGenerateDomain> createQuiz(String idUser) {
        AtomicInteger sequenceAllQuizByUser = new AtomicInteger(0);
        var uuidUser = UUID.fromString(idUser);
        UserDomain userDomain =  generatedQuiz.getUser(uuidUser);
        List<QuizGenerateDomain> listQuizGenerateDomain = new ArrayList<>();
        List<String> allCategory = generatedQuiz.getCategory();

        var hasQuizByUser = generatedQuiz.
                existsQuizByUser(uuidUser);

        if(hasQuizByUser){
            sequenceAllQuizByUser.set(generatedQuiz.findByUserEntities(uuidUser)
                    .getFirst().getQuantityQuizGenerated());

            if (sequenceAllQuizByUser.get() >= 3) {
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
                quizGenerateDomain.getAskEntities().setIdAsk(askDomain.getIdAsk());
            }
            quizGenerateDomain.setQuantityQuizGenerated(sequenceAllQuizByUser.get());

            var answerCorrect = getAnswerCorrect(userDomain, x);
            var listAllAnswers = generatedQuiz.findByAnswerRandoms(x, answerCorrect.substring(0,1));

            listAllAnswers.add(answerCorrect);
            Collections.shuffle(listAllAnswers);
            quizGenerateDomain.setAllAnswers(listAllAnswers);
            quizGenerateDomain.setQuantityQuizGenerated(sequenceAllQuizByUser.get());
            quizGenerateDomain.setPositionCorrectAnswer(getAPositionAnswerCorrect(listAllAnswers, answerCorrect));
            quizGenerateDomain.getUserEntities().setIdUser(uuidUser);
            listQuizGenerateDomain.add(quizGenerateDomain);
        });

        listQuizGenerateDomain.forEach(x -> {
            generatedQuiz.saveQuiz(x);
        });

        return listQuizGenerateDomain;
    }

    private String getAnswerCorrect(UserDomain userDomain, String category){
        return switch (category){
            case "Local Nascimento" -> userDomain.getHomeTown();
            case "Data Nascimento" -> userDomain.getBirthDate().toString();
            case "NOME"  -> userDomain.getUserName();

            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }

    private int getAPositionAnswerCorrect(List<String> allAnswer, String answerCorrect){
        for (int i = 0; i <= 4; i++) {
            if (Objects.equals(allAnswer.get(i), answerCorrect)){
                return i;
            }
        }
        throw new RuntimeException("Nao encontrado a resposta correta");
    }
}
