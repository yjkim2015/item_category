package com.musinsa.category.gateway;

import com.musinsa.category.dto.Category;
import com.musinsa.category.exception.CategoryErrorCode;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryGatewayImpl implements CategoryGateway {
    private final CategoryRepository categoryRepository;
    @Override
    public Category.QueryDTO getCategory(Long brandId) {
        com.musinsa.category.entity.Category category = categoryRepository.findById(brandId).orElseThrow(() -> new CustomException(CategoryErrorCode.NO_CONTENTS, brandId));
        return new Category.QueryDTO(category.getId(), category.getName());
    }
}
