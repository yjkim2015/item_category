package com.musinsa.category.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BrandLowestPriceForAllCategoriesResponse {
    private String brandName;
    private List<CategoryPrice.Response> categories;
    private String totalPrice;
}
