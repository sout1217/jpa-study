package com.relation.jpa.dto.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.relation.jpa.entity.Category;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class CategoryResponseDto {

    @JsonProperty(namespace = "categoryId")
    private Long id;

    private String name;

    public static CategoryResponseDto from(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.id = category.getId();
        dto.name = category.getName();
        return dto;
    }

    public static List<CategoryResponseDto> from(List<Category> categories) {
        return categories.stream().map(CategoryResponseDto::from).collect(Collectors.toList());
    }
}
