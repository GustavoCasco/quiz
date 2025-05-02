package br.com.quiz.askanswer.domain.enums;

import java.util.Arrays;

public enum CategoryEnum {

    BIRTH_DAY("Data Nascimento"), BIRTH_LOCAL("Local Nascimento"), NAME("NOME");

    private final String category;

    CategoryEnum(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public static CategoryEnum getValue(String category){
        return Arrays.stream(CategoryEnum.values())
                .filter(s -> s.getCategory().equals(category))
                .findFirst().orElseThrow(() -> new RuntimeException("Categoria nao existe"));
    }
}
