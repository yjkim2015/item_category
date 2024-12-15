package com.musinsa.category.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "product_id") // 외래 키를 사용하여 상품과 연결
    private Product product;  // 상품 정보

    private BigDecimal amount;  // 가격

    public Price(BigDecimal amount) {
        this.amount = amount;
    }

    public Price(Product product, BigDecimal amount) {
        this.product = product;
        this.amount = amount;
    }

    public Price(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }
}
