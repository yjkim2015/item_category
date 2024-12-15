package com.musinsa.category.controller;


import com.musinsa.category.dto.BrandLowestPriceForAllCategoriesResponse;
import com.musinsa.category.dto.CategoryLowHighPriceResponse;
import com.musinsa.category.dto.GlobalApiResponse;
import com.musinsa.category.dto.CategoryLowestPriceBrandResponse;
import com.musinsa.category.service.CategoryPriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryPriceController {

    private final CategoryPriceService categoryPriceService;

    @Operation(
            summary = "카테고리 별 최저가격인 브랜드 및 총액 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 카테고리별 가격 정보가 조회됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @GetMapping("/categories/lowest-price-brand")
    public GlobalApiResponse<CategoryLowestPriceBrandResponse> getCategoriesLowestPriceBrand() {
        return GlobalApiResponse.ok(categoryPriceService.getCategoriesLowestPriceBrand());
    }

    @Operation(
            summary = "단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 카테고리별 가격 정보가 조회됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @GetMapping("/brand/lowest-price-for-all-categories")
    public GlobalApiResponse<BrandLowestPriceForAllCategoriesResponse> getBrandLowestPriceForAllCategories() {
        return GlobalApiResponse.ok(categoryPriceService.getBrandLowestPriceForAllCategories());
    }

    @Operation(
            summary = "카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 카테고리별 가격 정보가 조회됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @GetMapping("/category-low-high-price")
    public GlobalApiResponse<CategoryLowHighPriceResponse> getLowestAndHighestPriceBrandByCategoryName(@RequestParam("categoryName") String categoryName) {
        return GlobalApiResponse.ok(categoryPriceService.getLowestAndHighestBrandPriceByCategoryName(categoryName));
    }
}