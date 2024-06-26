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
    @Column(name = "store_amount")
    Float storeAmount = 0.0f;
    @Column(name = "warehouse_amount")
    Float warehouseAmount = 0.0f;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<ProductPriceHistory> productPriceHistoryList;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<InvoiceDocumentItem> productDocumentItemList;
}
