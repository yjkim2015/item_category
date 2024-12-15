package com.musinsa.category.gateway;

import com.musinsa.category.entity.Brand;
import com.musinsa.category.exception.BrandErrorCode;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandGatewayImpl implements BrandGateway {

    private final BrandRepository brandRepository;

    @Override
    public com.musinsa.category.dto.Brand.QueryDTO getBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new CustomException(BrandErrorCode.NO_CONTENTS, brandId));

        return new com.musinsa.category.dto.Brand.QueryDTO(brand.getId(), brand.getName());
    }

    @Override
    public Boolean addBrand(String brandName) {

        try {
            brandRepository.save(new Brand(brandName));
        }
        catch (DataIntegrityViolationException e) {
            throw new CustomException(BrandErrorCode.BRAND_EXIST, false);
        }
        catch (Exception ex) {
            throw new CustomException(BrandErrorCode.SAVE_ERROR, false);
        }
        return true;
    }

    @Override
    public Boolean updateBrand(Long brandId, String brandName) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new CustomException(BrandErrorCode.NO_CONTENTS, brandId));
        try {
            brand.setName(brandName);
            brandRepository.save(brand);
        }
        catch (Exception ex) {
            throw new CustomException(BrandErrorCode.UPDATE_ERROR, false);
        }
        return true;
    }

    @Override
    public Boolean deleteBrand(Long brandId) {
        brandRepository.findById(brandId).orElseThrow(() -> new CustomException(BrandErrorCode.NO_CONTENTS, brandId));

        try {
            brandRepository.deleteById(brandId);
        }
        catch (Exception ex) {
            throw new CustomException(BrandErrorCode.DELETE_ERROR, false);
        }

        return true;
    }
}
