package com.musinsa.category.repository;


import com.musinsa.category.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryPriceRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT c.name, b.name, pr.amount " +
            "FROM PRODUCT p " +
            "LEFT JOIN CATEGORY c ON p.category_id = c.id " +
            "LEFT JOIN BRAND b ON p.brand_id = b.id " +
            "LEFT JOIN PRICE pr ON p.id = pr.product_id " +
            "WHERE p.id = ( " +
            "    SELECT p2.id " +
            "    FROM PRODUCT p2 " +
            "    LEFT JOIN PRICE pr2 ON p2.id = pr2.product_id " +
            "    LEFT JOIN BRAND b2 ON p2.brand_id = b2.id " +
            "    WHERE p2.category_id = c.id " +
            "    ORDER BY pr2.amount ASC, b2.name DESC " +
            "    LIMIT 1 " +
            ") " +
            "GROUP BY c.name, b.name " +
            "ORDER BY c.id ASC", nativeQuery = true)
    List<Object[]> findLowestPriceByCategory();
}