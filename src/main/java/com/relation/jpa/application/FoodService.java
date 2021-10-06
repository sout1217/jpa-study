package com.relation.jpa.application;

import com.relation.jpa.entity.Food;
import com.relation.jpa.entity.FoodCategory;
import com.relation.jpa.entity.FoodTag;
import com.relation.jpa.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;

    public Food getFood(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found entity"));
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public Page<Food> getFoods(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    public Food getFoodWithCountry(Long id) {

        Food food = foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found entity"));

        /*
        * getId() 는 proxy 가 이미 가지고 있기 때문에 다른 필드를 사용하여야 한다
        * fetch join country
        * */
        fetchJoinCountry(food);

        return food;
    }

    public Food getFoodWithCountryAndTags(Long id) {

        Food food = foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found entity"));

        fetchJoinCountry(food);

        /* fetch join foodTag fetch join tag */
        fetchJoinTags(food);

        return food;
    }

    public Food getFoodWithCountryAndTagsAndCategories(Long id) {

        Food food = foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found entity"));

        fetchJoinCountry(food);
        fetchJoinTags(food);

        /* fetch join foodCategory fetch join category */
        fetchJoinCategories(food);

        return food;
    }

    private void fetchJoinCountry(Food food) {
        food.getCountry().getName();
    }
    private void fetchJoinTags(Food food) {

        for (FoodTag foodTag : food.getFoodTags()) {
            foodTag.getTag().getName();
        }
    }
    private void fetchJoinCategories(Food food) {
        for (FoodCategory foodCategory : food.getFoodCategories()) {
            foodCategory.getCategory().getName();
        }
    }
}
