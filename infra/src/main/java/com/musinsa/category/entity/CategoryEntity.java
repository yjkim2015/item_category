package com.musinsa.category.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CATEGORY")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // 카테고리 이름 (예: 상의, 아우터, 바지, 스니커즈 등)
}
