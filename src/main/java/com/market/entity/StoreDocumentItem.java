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
@Table(name = "store_document_items")
public class StoreDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_document_item_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "store_document_id",nullable = false)
    StoreDocument storeDocument;
    @Column(name = "product_amount",nullable = false)
    Float amount;
    @Column(name = "total_amount",nullable = false)
    Float totalAmount;
    @ManyToOne
    @JoinColumn(name = "invoice_document_item_id",nullable = false)
    InvoiceDocumentItem invoiceDocumentItem;
    @OneToMany(mappedBy = "storeDocumentItem",cascade = CascadeType.ALL)
    List<ReturnStoreDocumentItem> returnStoreDocumentItemList;
    @OneToMany(mappedBy = "storeDocumentItem",cascade = CascadeType.ALL)
    List<SellDocumentItem> sellDocumentItemList;
}