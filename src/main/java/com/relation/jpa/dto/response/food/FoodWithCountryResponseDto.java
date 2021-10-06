package com.relation.jpa.dto.response.food;

import com.relation.jpa.dto.response.country.CountryResponseDto;
import com.relation.jpa.entity.Food;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class FoodWithCountryResponseDto extends FoodResponseDto {

    private CountryResponseDto country;

    public FoodWithCountryResponseDto(Food food) {
        super(food);
        this.country = CountryResponseDto.from(food.getCountry());
    }

    public static FoodWithCountryResponseDto from(Food food) {
        return new FoodWithCountryResponseDto(food);
    }
}
