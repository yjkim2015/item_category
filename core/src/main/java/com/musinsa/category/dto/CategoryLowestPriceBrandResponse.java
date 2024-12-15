package com.musinsa.category.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryLowestPriceBrandResponse {
    private List<CategoryBrandPrice.Response> categoryPrices;
    private BigDecimal totalPrice;
}
