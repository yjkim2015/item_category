package com.musinsa.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Product {

    @AllArgsConstructor
    @Getter
    public static class QueryDTO {
        private Long id;
        private Brand.QueryDTO brand;
        private Category.QueryDTO category;
        private Price.QueryDTO price;

        public QueryDTO(Brand.QueryDTO brand, Category.QueryDTO category) {
            this.brand = brand;
            this.category = category;
        }

        public QueryDTO(Brand.QueryDTO brand, Category.QueryDTO category, Price.QueryDTO price) {
            this.brand = brand;
            this.category = category;
            this.price = price;
        }
    }
}
