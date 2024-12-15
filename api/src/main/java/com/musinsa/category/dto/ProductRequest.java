package com.musinsa.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.math.BigDecimal;
public class ProductRequest {

    @Getter
    @Schema(description = "상품 추가 요청 객체")
    public static class Add {
        @Schema(description = "카테고리 아이디")
        private Long categoryId;
        @Schema(description = "브랜드 아이디")
        private Long brandId;
        @Schema(description = "가격")
        private BigDecimal price;
    }

    @Getter
    @Schema(description = "상품 수정 요청 객체")
    public static class Update {
        @Schema(description = "상품 아이디")
        private Long productId;
        @Schema(description = "브랜드 아이디")
        private Long brandId;
        @Schema(description = "카테고리 아이디")
        private Long categoryId;
        @Schema(description = "가격")
        private BigDecimal price;
    }

    @Getter
    @Schema(description = "상품 삭제 요청 객체")
    public static class Delete {
        @Schema(description = "상품 아이디")
        private Long productId;
    }
}
