package com.musinsa.category.service;


import com.musinsa.category.dto.*;
import com.musinsa.category.exception.CategoryErrorCode;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.gateway.CategoryPriceGateway;
import com.musinsa.category.util.FormatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryPriceService {
    private final CategoryPriceGateway categoryPriceGateway;

    public CategoryLowestPriceBrandResponse getCategoriesLowestPriceBrand() {
        List<CategoryBrandPrice.QueryDTO> lowestPriceByCategory = categoryPriceGateway.getLowestPriceByCategory();

        BigDecimal totalPrice = lowestPriceByCategory.stream().map(CategoryBrandPrice.QueryDTO::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CategoryLowestPriceBrandResponse(
                lowestPriceByCategory.stream().map(CategoryBrandPrice.QueryDTO::toResponse).collect(Collectors.toList()),
                totalPrice
        );
    }

    public BrandLowestPriceForAllCategoriesResponse getBrandLowestPriceForAllCategories() {
        Brand.QueryDTO brand = categoryPriceGateway.findLowestTotalPriceBrandName();

        List<CategoryPrice.QueryDTO> categories = categoryPriceGateway.findCategoriesPriceByBrandId(brand.getId());

        BigDecimal totalPrice = categories.stream().map(x -> x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new BrandLowestPriceForAllCategoriesResponse(
                brand.getName(),
                categories.stream().map(CategoryPrice.QueryDTO::toResponse).collect(Collectors.toList()),
                FormatUtils.toThousandsString(totalPrice)
        );
    }

    public CategoryLowHighPriceResponse getLowestAndHighestBrandPriceByCategoryName(String categoryName) {
        BrandPrice.QueryDTO lowestPriceBrandByCategoryName = categoryPriceGateway.findLowestAndHighestPriceBrandByCategoryName(categoryName, false);

        BrandPrice.QueryDTO highestPriceBrandByCategoryName = categoryPriceGateway.findLowestAndHighestPriceBrandByCategoryName(categoryName, true);

        return new CategoryLowHighPriceResponse(
                categoryName,
                lowestPriceBrandByCategoryName.toResponse(),
                highestPriceBrandByCategoryName.toResponse()
        );
    }
}
