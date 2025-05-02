package br.com.quiz.askanswer.domain.model;


public class AskDomain {

    private String enunciated;
    private String category;

    public AskDomain(String categoryDomain, String enunciated) {
        this.category = categoryDomain;
        this.enunciated = enunciated;
    }

    public AskDomain() {
    }

    public String getEnunciated() {
        return enunciated;
    }

    public void setEnunciated(String enunciated) {
        this.enunciated = enunciated;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
