package com.relation.jpa.dto.response.food;

import com.relation.jpa.entity.Food;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class FoodResponseDto {

    protected Long id;
    protected String name;

    public FoodResponseDto(Food food) {
        this.id = food.getId();
        this.name = food.getName();
    }

    public static FoodResponseDto from(Food food) {
        return new FoodResponseDto(food);
    }

    public static List<FoodResponseDto> from(List<Food> foods) {
        return foods.stream().map(FoodResponseDto::from).collect(Collectors.toList());
    }
}
