package com.example.tdd_study.product.domain.entity;

import com.example.tdd_study.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingType sellingType;

    private String name;

    private int price;

    @Builder
    private Product(String productNumber, ProductType type, ProductSellingType sellingType, String name, int price) {
        this.productNumber = productNumber;
        this.type = type;
        this.sellingType = sellingType;
        this.name = name;
        this.price = price;
    }
}
