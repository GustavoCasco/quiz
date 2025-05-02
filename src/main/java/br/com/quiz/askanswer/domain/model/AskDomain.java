package br.com.quiz.askanswer.domain.model;


import java.util.UUID;

public class AskDomain {

    private UUID idAsk;
    private String enunciated;
    private String category;

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

    public AskDomain(UUID idAsk, String enunciated, String category) {
        this.idAsk = idAsk;
        this.enunciated = enunciated;
        this.category = category;
    }

    public UUID getIdAsk() {
        return idAsk;
    }

    public void setIdAsk(UUID idAsk) {
        this.idAsk = idAsk;
    }
}
