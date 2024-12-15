package com.musinsa.category.gateway;

import com.musinsa.category.dto.Price;
import com.musinsa.category.dto.Product;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.exception.ProductErrorCode;
import com.musinsa.category.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceGatewayImpl implements PriceGateway {

    private final PriceRepository priceRepository;
    @Override
    public Price.QueryDTO getPrice(Long productId) {

        com.musinsa.category.entity.Price price = priceRepository.findByProductId(productId).orElseThrow(() -> new CustomException(ProductErrorCode.NO_CONTENTS, productId));

        return new Price.QueryDTO(price.getId(), price.getAmount());
    }
}
