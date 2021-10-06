package com.relation.jpa.controller;

import com.relation.jpa.application.CategoryService;
import com.relation.jpa.dto.response.category.CategoryResponseDto;
import com.relation.jpa.entity.Category;
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
public class CategoryApi {

    private final CategoryService categoryService;

    /**
     * 카테고리 단 건 조회
     * @param id 카테고리 아이디
     * */
    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {

        Category category = categoryService.getCategory(id);

        CategoryResponseDto responseDto = CategoryResponseDto.from(category);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * 카테고리 모든 리스트 조회
     * */
    @GetMapping("/categories/all")
    public ResponseEntity<?> getCategories() {

        List<Category> categories = categoryService.getCategories();

        List<CategoryResponseDto> responseDtos = CategoryResponseDto.from(categories);

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * 카테고리 페이징 조회
     * @param pageable 페이징
     * */
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(@PageableDefault Pageable pageable) {

        Page<Category> categories = categoryService.getCategories(pageable);

        Page<CategoryResponseDto> responseDtos = categories.map(CategoryResponseDto::from);

        return ResponseEntity.ok(responseDtos);
    }

    // 1. 카테고리에 해당하는 음식들 조회
}
