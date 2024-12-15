package com.musinsa.category.repository;

import com.musinsa.category.entity.Price;
import com.musinsa.category.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findByProductId(Long productId);
}
