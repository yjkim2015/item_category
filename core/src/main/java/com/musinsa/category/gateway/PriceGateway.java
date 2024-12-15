package com.musinsa.category.gateway;

import com.musinsa.category.dto.Price;

public interface PriceGateway {
    Price.QueryDTO getPrice(Long productId);
}
