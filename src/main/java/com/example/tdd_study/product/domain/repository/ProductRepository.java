package com.example.tdd_study.product.domain.repository;

import com.example.tdd_study.product.domain.entity.Product;
import com.example.tdd_study.product.domain.entity.ProductSellingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllBySellingTypeIn(List<ProductSellingType> sellingTypes);
}
