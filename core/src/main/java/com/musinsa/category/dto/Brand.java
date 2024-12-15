package com.musinsa.category.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

public class Brand {
    @AllArgsConstructor
    @Getter
    public static class QueryDTO {
        private Long id;
        private String name;
    }
}
