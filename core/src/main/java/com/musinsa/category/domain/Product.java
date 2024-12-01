package com.musinsa.category.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private Long id;
    private Brand brand;
    private Category category;
}
