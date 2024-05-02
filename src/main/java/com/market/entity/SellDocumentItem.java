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
@Table(name = "sell_document_items")
public class SellDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_document_item_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "sell_document_id",nullable = false)
    SellDocument sellDocument;
    @ManyToOne
    @JoinColumn(name = "store_document_item_id",nullable = false)
    StoreDocumentItem storeDocumentItem;
    @Column(name = "product_amount",nullable = false)
    Float amount;
    @Column(name = "product_price",nullable = false)
    Float productPrice;
}
