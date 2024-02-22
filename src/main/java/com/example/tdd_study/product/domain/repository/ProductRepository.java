package com.example.tdd_study.product.domain.repository;

import com.example.tdd_study.product.domain.entity.Product;
import com.example.tdd_study.product.domain.entity.ProductSellingStatus;
import com.example.tdd_study.product.domain.entity.ProductSellingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingStatuses);

    List<Product> findAllByProductNumberIn(List<String> productNumbers);

    @Query(value = "select p.product_number from product p order by id desc limit 1", nativeQuery = true)
    String findLatestProductNumber();
}
