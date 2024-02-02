package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_document_items")
public class ProductDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_document_id",nullable = false)
    ProductDocument productDocument;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;
    @Column(name = "product_amount",nullable = false)
    Float amount;
}