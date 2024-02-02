package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long id;
    @Column(name = "product_name",nullable = false,unique = true)
    String name;
    @ManyToOne
    @JoinColumn(name = "unit_type_id",nullable = false)
    UnitType unitType;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    Category category;
    @ManyToOne
    @JoinColumn(name = "product_price",nullable = false)
    ProductPrice price;
    @Column(name = "total_amount",nullable = false)
    Float totalAmount;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductDocumentItem> productDocumentItemList;
}
