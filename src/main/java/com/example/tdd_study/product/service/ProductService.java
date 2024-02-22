package com.example.tdd_study.product.service;

import com.example.tdd_study.product.domain.entity.Product;
import com.example.tdd_study.product.domain.entity.ProductSellingStatus;
import com.example.tdd_study.product.domain.entity.ProductSellingType;
import com.example.tdd_study.product.domain.repository.ProductNumberFactory;
import com.example.tdd_study.product.domain.repository.ProductRepository;
import com.example.tdd_study.product.dto.request.ProductCreateServiceRequest;
import com.example.tdd_study.product.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductNumberFactory productNumberFactory;

    @Transactional
    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = productNumberFactory.createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);
    }

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
