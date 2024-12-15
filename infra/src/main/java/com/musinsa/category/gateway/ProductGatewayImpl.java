package com.musinsa.category.gateway;


import com.musinsa.category.dto.Brand;
import com.musinsa.category.dto.Category;
import com.musinsa.category.dto.Price;
import com.musinsa.category.dto.Product;
import com.musinsa.category.exception.BrandErrorCode;
import com.musinsa.category.exception.CategoryErrorCode;
import com.musinsa.category.exception.CustomException;
import com.musinsa.category.exception.ProductErrorCode;
import com.musinsa.category.repository.BrandRepository;
import com.musinsa.category.repository.CategoryRepository;
import com.musinsa.category.repository.PriceRepository;
import com.musinsa.category.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway{

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public Product.QueryDTO getProduct(Long productId) {
        com.musinsa.category.entity.Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(ProductErrorCode.NO_CONTENTS, productId));

        return new Product.QueryDTO(
            product.getId(),
            new Brand.QueryDTO(product.getBrand().getId(), product.getBrand().getName()),
            new Category.QueryDTO(product.getCategory().getId(), product.getCategory().getName()),
            new Price.QueryDTO(product.getPrice().getId(), product.getPrice().getAmount())
        );
    }

    @Override
    @Transactional
    public Boolean addProduct(Long categoryId, Long brandId, BigDecimal amount) {

        com.musinsa.category.entity.Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new CustomException(BrandErrorCode.NO_CONTENTS, brandId));
        com.musinsa.category.entity.Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CustomException(CategoryErrorCode.NO_CONTENTS, categoryId));

        try {
            com.musinsa.category.entity.Price price = new com.musinsa.category.entity.Price(amount);
            com.musinsa.category.entity.Product product = new com.musinsa.category.entity.Product(brand, category, price);
            price.setProduct(product);
            
            productRepository.save(product);
        }
        catch (Exception ex) {
            throw new CustomException(ProductErrorCode.SAVE_ERROR, false);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateProduct(Long productId, Long brandId, Long categoryId, BigDecimal amount) {

        com.musinsa.category.entity.Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(ProductErrorCode.NO_CONTENTS, productId));

        com.musinsa.category.entity.Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new CustomException(BrandErrorCode.NO_CONTENTS, brandId));
        com.musinsa.category.entity.Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CustomException(CategoryErrorCode.NO_CONTENTS, categoryId));

        com.musinsa.category.entity.Price price = priceRepository.findByProductId(productId).orElseThrow(() -> new CustomException(ProductErrorCode.NO_CONTENTS, product));
        price.setAmount(amount);

        try {
            product.setBrand(brand);
            product.setCategory(category);
            product.setPrice(price);
            price.setProduct(product);
            productRepository.save(product);
        }
        catch (Exception ex) {
            throw new CustomException(ProductErrorCode.UPDATE_ERROR, false);
        }

        return true;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        productRepository.findById(productId).orElseThrow(() -> new CustomException(ProductErrorCode.NO_CONTENTS, productId));

        try {
            productRepository.deleteById(productId);
        }
        catch (Exception ex) {
            throw new CustomException(ProductErrorCode.DELETE_ERROR, false);
        }

        return true;
    }
}
