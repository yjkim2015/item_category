package com.musinsa.category.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BRAND")
@Data
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //브랜드 이름
}

