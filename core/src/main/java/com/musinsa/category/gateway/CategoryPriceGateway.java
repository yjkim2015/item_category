package com.musinsa.category.gateway;

import com.musinsa.category.dto.Brand;
import com.musinsa.category.dto.CategoryBrandPrice;
import com.musinsa.category.dto.BrandPrice;
import com.musinsa.category.dto.CategoryPrice;

import java.util.List;

public interface CategoryPriceGateway {
    List<CategoryBrandPrice.QueryDTO> getLowestPriceByCategory();

    Brand.QueryDTO findLowestTotalPriceBrandName();

    List<CategoryPrice.QueryDTO> findCategoriesPriceByBrandId(Long brandId);

    BrandPrice.QueryDTO findLowestAndHighestPriceBrandByCategoryName(String categoryName, Boolean isOrderedDescByPrice);
}
