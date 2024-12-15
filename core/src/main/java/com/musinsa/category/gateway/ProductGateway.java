package com.musinsa.category.gateway;

import com.musinsa.category.dto.Product;

import java.math.BigDecimal;

public interface ProductGateway {
    Product.QueryDTO getProduct(Long productId);

    Boolean addProduct(Long categoryId, Long brandId, BigDecimal price);

    Boolean updateProduct(Long productId, Long brandId, Long categoryId, BigDecimal amount);

    Boolean deleteProduct(Long productId);
}
