package com.musinsa.category.gateway;

import com.musinsa.category.dto.Category;

public interface CategoryGateway {
    Category.QueryDTO getCategory(Long brandId);
}
