package com.musinsa.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

public class Price {

    @Getter
    @AllArgsConstructor
    public static class QueryDTO {
        private Long id;
        private BigDecimal amount;  // 가격

        public QueryDTO(BigDecimal amount) {
            this.amount = amount;
        }
    }
}
