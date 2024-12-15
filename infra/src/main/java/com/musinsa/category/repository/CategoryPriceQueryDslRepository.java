package com.musinsa.category.repository;


import com.musinsa.category.dto.Brand;
import com.musinsa.category.dto.BrandPrice;
import com.musinsa.category.dto.CategoryPrice;
import com.musinsa.category.entity.QBrand;
import com.musinsa.category.entity.QCategory;
import com.musinsa.category.entity.QPrice;
import com.musinsa.category.entity.QProduct;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryPriceQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public List<CategoryPrice.QueryDTO> findLowestPriceByBrandName(long brandId) {
        // Q 클래스들 생성
        QProduct product = QProduct.product;
        QCategory category = QCategory.category;
        QBrand brand = QBrand.brand;
        QPrice price = QPrice.price;

        // JPAQueryFactory를 사용한 쿼리 작성
        return queryFactory
                .select(Projections.constructor(CategoryPrice.QueryDTO.class, category.name, price.amount))  // SELECT C.NAME, PR.AMOUNT
                .from(product)
                .leftJoin(product.category, category)  // LEFT JOIN CATEGORY C
                .leftJoin(product.brand, brand)        // LEFT JOIN BRAND B
                .leftJoin(product.price, price)      // LEFT JOIN PRICE PR
                .where(brand.id.eq(brandId))      // WHERE B.NAME = 'brandName'
                .fetch();
    }

    public Brand.QueryDTO findLowestTotalPriceBrandName() {
        // Q 클래스들 생성
        QProduct product = QProduct.product;
        QCategory category = QCategory.category;
        QBrand brand = QBrand.brand;
        QPrice price = QPrice.price;

        // 서브쿼리로 최소 가격 구하기
        var subQuery = queryFactory
                .select(price.amount.min())  // MIN(price.amount) 계산
                .from(price)
                .leftJoin(price.product, product)
                .where(product.brand.id.eq(brand.id))  // 해당 브랜드의 제품
                .groupBy(product.category.id);  // 카테고리별로 그룹화


        return queryFactory
                .select(Projections.constructor(Brand.QueryDTO.class, brand.id, brand.name))
                .from(product)
                .leftJoin(product.brand, brand)
                .leftJoin(product.price, price)
                .where(price.amount.in(subQuery))
                .groupBy(brand.id)
                .orderBy(price.amount.sum().asc())
                .limit(1)
                .fetchOne();
    }
    public BrandPrice.QueryDTO findLowestOrHighestPriceBrandByCategoryName(String categoryName, Boolean isOrderedDescByPrice) {
        QProduct product = QProduct.product;
        QCategory category = QCategory.category;
        QBrand brand = QBrand.brand;
        QPrice price = QPrice.price;

        OrderSpecifier<BigDecimal> orderMethod = price.amount.asc();
        if (isOrderedDescByPrice) {
            orderMethod = price.amount.desc();
        }

        return queryFactory
                .select(Projections.constructor(BrandPrice.QueryDTO.class, brand.name, price.amount))
                .from(product)
                .leftJoin(product.brand, brand)
                .leftJoin(product.price, price)
                .leftJoin(product.category, category)
                .where(category.name.eq(categoryName))
                .orderBy(orderMethod)
                .limit(1)
                .fetchOne();
    }

}
