package br.com.quiz.askanswer.adapters.out.persistence.entities;

import br.com.quiz.askanswer.domain.enums.CategoryEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_respostas_random")
public class AllAnswerRandomEntities implements Serializable {

    @Id
    private UUID uuid;
    private String answer;

    @Column(name = "category")
    private CategoryEnum categoryEnum;

    public AllAnswerRandomEntities() {
    }

    public AllAnswerRandomEntities(UUID uuid, String answer, CategoryEnum categoryEnum) {
        this.uuid = uuid;
        this.answer = answer;
        this.categoryEnum = categoryEnum;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
