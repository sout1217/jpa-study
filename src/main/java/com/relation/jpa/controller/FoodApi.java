package com.relation.jpa.controller;

import com.relation.jpa.application.FoodService;
import com.relation.jpa.dto.response.food.FoodResponseDto;
import com.relation.jpa.dto.response.food.FoodWithCountryAndTagsAndCategoriesResponseDto;
import com.relation.jpa.dto.response.food.FoodWithCountryAndTagsResponseDto;
import com.relation.jpa.dto.response.food.FoodWithCountryResponseDto;
import com.relation.jpa.entity.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FoodApi {

    private final FoodService foodService;

    /**
     * 음식 단 건 조회
     * @param id 카테고리 아이디
     * */
    @GetMapping("/foods/{id}")
    public ResponseEntity<?> getFood(@PathVariable("id") Long id) {

        Food food = foodService.getFood(id);

        FoodResponseDto responseDto = FoodResponseDto.from(food);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * 음식 단 건 조회 JOIN 국가
     * @param id 카테고리 아이디
     * */
    @GetMapping("/foods/{id}/country")
    public ResponseEntity<?> getFoodWithCountry(@PathVariable("id") Long id) {

        Food food = foodService.getFoodWithCountry(id);

        FoodWithCountryResponseDto responseDto = FoodWithCountryResponseDto.from(food);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * 음식 단 건 조회 JOIN 국가, 태그
     * @param id 카테고리 아이디
     * */
    @GetMapping("/foods/{id}/country-tags")
    public ResponseEntity<?> getFoodWithCountryAndTags(@PathVariable("id") Long id) {

        Food food = foodService.getFoodWithCountryAndTags(id);

        FoodWithCountryAndTagsResponseDto responseDto = FoodWithCountryAndTagsResponseDto.from(food);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * 음식 단 건 조회 JOIN 국가, 태그, 카테고리
     * @param id 카테고리 아이디
     * */
    @GetMapping("/foods/{id}/country-tags-categories")
    public ResponseEntity<?> getFoodWithCountryAndTagsAndCategories(@PathVariable("id") Long id) {

        Food food = foodService.getFoodWithCountryAndTagsAndCategories(id);

        FoodWithCountryAndTagsAndCategoriesResponseDto responseDto = FoodWithCountryAndTagsAndCategoriesResponseDto.from(food);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * 음식 모든 리스트 조회
     * */
    @GetMapping("/foods/all")
    public ResponseEntity<?> getFoods() {

        List<Food> foods = foodService.getFoods();

        List<FoodResponseDto> responseDtos = FoodResponseDto.from(foods);

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * 음식 페이징 조회
     * @param pageable 페이징
     * */
    @GetMapping("/foods")
    public ResponseEntity<?> getFoods(@PageableDefault Pageable pageable) {

        Page<Food> foods = foodService.getFoods(pageable);

        Page<FoodResponseDto> responseDtos = foods.map(FoodResponseDto::from);

        return ResponseEntity.ok(responseDtos);
    }
}
