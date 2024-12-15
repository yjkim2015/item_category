package com.musinsa.category.gateway;


import com.musinsa.category.dto.Brand;
import com.musinsa.category.dto.CategoryBrandPrice;
import com.musinsa.category.dto.BrandPrice;
import com.musinsa.category.dto.CategoryPrice;
import com.musinsa.category.exception.CategoryErrorCode;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.repository.CategoryPriceQueryDslRepository;
import com.musinsa.category.repository.CategoryPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryPriceGatewayImpl implements CategoryPriceGateway {
    private final CategoryPriceRepository categoryPriceRepository;

    private final CategoryPriceQueryDslRepository categoryPriceQueryDslRepository;

    @Override
    public List<CategoryBrandPrice.QueryDTO> getLowestPriceByCategory() {
        /*
        에러가 나왔다고 프론트에게 Exception을 주는게 맞는것인가?
        만약 이 로직 이후에 다른 로직이 있는데도 이 데이터가 없다고 Throw를 던지면 문제가 있을 듯..
        다음 로직이 어떤것인지에 따라 달라 질 수 있을 듯
        로깅만 하고 빈 데이터를 던지는게 맞지 않는지.
        1.
        try {

        }
        catch (DataAccessException e) {
            throw new RuntimeException("Database connection error", e); // 예외 발생
        }
        2.
        try {
        }
        catch(Exception ex) {
           log.error(ex.getMessage());
           return null;
        }

        */

        List<Object[]> results = categoryPriceRepository.findLowestPriceByCategory();

        return results.stream()
                .map(result -> new CategoryBrandPrice.QueryDTO(
                        (String) result[0],    // categoryName
                        (String) result[1],    // brandName
                        (BigDecimal) result[2]))   // lowestPrice
                .collect(Collectors.toList());
    }

    @Override
    public Brand.QueryDTO findLowestTotalPriceBrandName() {
        return categoryPriceQueryDslRepository.findLowestTotalPriceBrandName();
    }

    @Override
    public List<CategoryPrice.QueryDTO> findCategoriesPriceByBrandId(Long brandId) {
        List<CategoryPrice.QueryDTO> result = categoryPriceQueryDslRepository.findLowestPriceByBrandName(brandId);
        return result;
    }
    @Override
    public BrandPrice.QueryDTO findLowestAndHighestPriceBrandByCategoryName(String categoryName, Boolean isOrderedDescByPrice) {
        BrandPrice.QueryDTO result = categoryPriceQueryDslRepository.findLowestOrHighestPriceBrandByCategoryName(categoryName, isOrderedDescByPrice);

        if (result == null) {
            throw new CustomException(CategoryErrorCode.NO_CONTENTS, categoryName);
        }

        return result;
    }

}
