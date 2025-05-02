package br.com.quiz.askanswer.domain.model;

import br.com.quiz.askanswer.domain.enums.CategoryEnum;

public class AllAnswerRandom {

    private String answer;
    private CategoryEnum categoryEnum;

    public AllAnswerRandom() {
    }

    public AllAnswerRandom(String answer, CategoryEnum categoryEnum) {
        this.answer = answer;
        this.categoryEnum = categoryEnum;
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
