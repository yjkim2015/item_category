package com.musinsa.category.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Price {
    private Long id;
    private Product product;
    private BigDecimal amount;
}
