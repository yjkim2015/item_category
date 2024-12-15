package com.musinsa.category.service;


import com.musinsa.category.dto.Brand;
import com.musinsa.category.gateway.BrandGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandGateway brandGateway;

    public Brand.QueryDTO getBrand(Long brandId) {
        return brandGateway.getBrand(brandId);
    }
    public Boolean addBrand(String brandName) {
        return brandGateway.addBrand(brandName);
    }

    public Boolean updateBrand(Long brandId, String brandName) {
        return brandGateway.updateBrand(brandId, brandName);
    }

    public Boolean deleteBrand(Long brandId) {
        return brandGateway.deleteBrand(brandId);
    }
}
