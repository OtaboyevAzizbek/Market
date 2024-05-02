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
@Table(name = "return_store_document_items")
public class ReturnStoreDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_store_document_item_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "return_store_document_id",nullable = false)
    ReturnStoreDocument storeDocument;
    @ManyToOne
    @JoinColumn(name = "store_document_item_id",nullable = false)
    StoreDocumentItem storeDocumentItem;
    @Column(name = "product_amount",nullable = false)
    Float amount;
}