package com.example.tdd_study.product.controller;

import com.example.tdd_study.product.dto.response.ProductResponse;
import com.example.tdd_study.product.service.ProductSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductSerivce productService;

    @GetMapping("/api/v1/products/selling")
    public List<ProductResponse> getSellingProducts() {
        return productService.getSellingProducts();
    }
}
