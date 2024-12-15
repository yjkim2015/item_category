package com.musinsa.category.dto;


import com.musinsa.category.dto.BrandPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryLowHighPriceResponse {
    private String CategoryName;
    private BrandPrice.Response lowestPriceBrand;
    private BrandPrice.Response highestPriceBrand;
}
