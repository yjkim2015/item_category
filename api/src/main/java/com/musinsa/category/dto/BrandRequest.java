package com.musinsa.category.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

public class BrandRequest {

    @Getter
    @Schema(description = "브랜드 추가 요청 객체")
    public static class Add {
        @Schema(description = "브랜드 이름")
        private String name;
    }

    @Getter
    @Schema(description = "브랜드 수정 요청 객체")
    public static class Update {
        @Schema(description = "브랜드 아이디")
        private Long id;
        @Schema(description = "브랜드 이름")
        private String name;
    }

    @Getter
    @Schema(description = "브랜드 제거 요청 객체")
    public static class Delete {
        @Schema(description = "브랜드 아이디")
        private Long id;
    }
}
