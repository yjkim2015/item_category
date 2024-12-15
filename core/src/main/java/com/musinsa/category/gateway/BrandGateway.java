package com.musinsa.category.gateway;

import com.musinsa.category.dto.Brand;

public interface BrandGateway {
    Brand.QueryDTO getBrand(Long brandId);
    Boolean addBrand(String brandName);

    Boolean updateBrand(Long brandId, String brandName);

    Boolean deleteBrand(Long brandId);

}
