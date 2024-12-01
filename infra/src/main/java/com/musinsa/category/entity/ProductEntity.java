package com.musinsa.category.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;  // 브랜드 정보

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;  // 카테고리 정보
}
