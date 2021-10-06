package com.relation.jpa.application;

import com.relation.jpa.entity.Category;
import com.relation.jpa.repository.CategoryRepository;
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
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategory(Long id) {

        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found entity"));
    }

    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }

    public Page<Category> getCategories(Pageable pageable) {

        return categoryRepository.findAll(pageable);
    }
}
