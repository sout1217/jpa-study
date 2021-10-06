package com.relation.jpa.dto.response.food;

import com.relation.jpa.dto.response.country.CountryResponseDto;
import com.relation.jpa.dto.response.tag.TagResponseDto;
import com.relation.jpa.entity.Food;
import com.relation.jpa.entity.FoodTag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class FoodWithCountryAndTagsResponseDto extends FoodResponseDto  {

    private CountryResponseDto country;
    private List<TagResponseDto> tags;

    public FoodWithCountryAndTagsResponseDto(Food food) {
        super(food);
        this.country = CountryResponseDto.from(food.getCountry());
        this.tags = TagResponseDto.from(food.getFoodTags().stream().map(FoodTag::getTag).collect(Collectors.toList()));
    }

    public static FoodWithCountryAndTagsResponseDto from(Food food) {
        return new FoodWithCountryAndTagsResponseDto(food);
    }
}
