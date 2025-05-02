package br.com.quiz.askanswer.adapters.out.persistence.entities;

import br.com.quiz.askanswer.domain.enums.CategoryEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_perguntas")
public class AskEntities implements Serializable {

    @Id
    private UUID idAsk;

    @Column(name = "enunciado")
    private String enunciated;

    @Column(name = "categoria")
    private CategoryEnum categoryEnum;

    @OneToMany(mappedBy = "askEntities")
    private List<QuizEntities> quizEntities;

    public AskEntities(UUID idAsk, String enunciated, CategoryEnum categoryEnum, List<QuizEntities> quizEntities) {
        this.idAsk = idAsk;
        this.enunciated = enunciated;
        this.categoryEnum = categoryEnum;
        this.quizEntities = quizEntities;
    }

    public AskEntities(){

    }

    public UUID getIdAsk() {
        return idAsk;
    }

    public void setIdAsk(UUID idAsk) {
        this.idAsk = idAsk;
    }

    public String getEnunciated() {
        return enunciated;
    }

    public void setEnunciated(String enunciated) {
        this.enunciated = enunciated;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public List<QuizEntities> getQuizEntities() {
        return quizEntities;
    }

    public void setQuizEntities(List<QuizEntities> quizEntities) {
        this.quizEntities = quizEntities;
    }
}
