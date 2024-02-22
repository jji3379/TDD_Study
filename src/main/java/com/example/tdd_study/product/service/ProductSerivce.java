package com.example.tdd_study.product.service;

import com.example.tdd_study.product.domain.entity.Product;
import com.example.tdd_study.product.domain.entity.ProductSellingType;
import com.example.tdd_study.product.domain.repository.ProductRepository;
import com.example.tdd_study.product.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSerivce {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingTypeIn(ProductSellingType.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

}
