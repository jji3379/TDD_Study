package com.example.tdd_study.product.domain.repository;

import com.example.tdd_study.product.domain.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.example.tdd_study.product.domain.entity.ProductSellingType.*;
import static com.example.tdd_study.product.domain.entity.ProductType.HANDMADE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @DisplayName("")
    @Test
    void findAllBySellingStatusIn() {
        // given
        Product product1 = Product.builder()
                .productNumber("001")
                .type(HANDMADE)
                .sellingType(SELLING)
                .name("아메리카노")
                .price(4000)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
                .type(HANDMADE)
                .sellingType(HOLD)
                .name("카페라떼")
                .price(4000)
                .build();

        Product product3 = Product.builder()
                .productNumber("001")
                .type(HANDMADE)
                .sellingType(STOP_SELLING)
                .name("팥빙수")
                .price(4000)
                .build();

        productRepository.saveAll(List.of(product1, product2, product3));

        // when
        List<Product> products = productRepository.findAllBySellingTypeIn(List.of(SELLING, HOLD));

        // then
        assertThat(products).hasSize(2)
                .extracting("productNumber", "name", "sellingType")
                .containsExactlyInAnyOrder(
                        tuple("001", "아메리카노", SELLING),
                        tuple("002", "카페라떼", HOLD)
                );
    }
}