package com.musinsa.category.service;


import com.musinsa.category.dto.Product;
import com.musinsa.category.gateway.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductGateway productGateway;
    private final CategoryGateway categoryGateway;
    private final BrandGateway brandGateway;

    private final PriceGateway priceGateway;
    public Product.QueryDTO getProduct(Long productId) {
        return productGateway.getProduct(productId);
    }

    public Boolean addProduct(Long categoryId, Long brandId, BigDecimal price) {
        return productGateway.addProduct(categoryId, brandId, price);
    }

    public Boolean updateProduct(Long productId, Long brandId, Long categoryId, BigDecimal amount) {

        return productGateway.updateProduct(productId, brandId, categoryId, amount);
    }

    public boolean deleteProduct(Long productId) {
        return productGateway.deleteProduct(productId);
    }

}