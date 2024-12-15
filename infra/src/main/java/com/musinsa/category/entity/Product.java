package com.musinsa.category.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;  // 브랜드 정보

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;  // 카테고리 정보

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Price price; // 가격을 별도의 엔티티로 관리

    public Product(Brand brand, Category category, Price price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }
}

