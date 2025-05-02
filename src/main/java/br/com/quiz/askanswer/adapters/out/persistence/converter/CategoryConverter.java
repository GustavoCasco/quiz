package br.com.quiz.askanswer.adapters.out.persistence.converter;

import br.com.quiz.askanswer.domain.enums.CategoryEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<CategoryEnum, String> {

    @Override
    public String convertToDatabaseColumn(CategoryEnum categoryEnum) {
        return categoryEnum != null ? categoryEnum.getCategory() : null;
    }

    @Override
    public CategoryEnum convertToEntityAttribute(String category) {
        return category != null ? CategoryEnum.getValue(category) : null;
    }
}
