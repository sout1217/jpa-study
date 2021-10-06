package com.relation.jpa.dto.response.country;

import com.relation.jpa.entity.Country;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class CountryResponseDto {

    private Long id;

    private String name;

    public CountryResponseDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public static CountryResponseDto from(Country country) {
        return new CountryResponseDto(country);
    }
}
