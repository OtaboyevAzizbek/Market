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
@Table(name = "invoice_document_items")
public class InvoiceDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_document_item_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "invoice_document_id",nullable = false)
    InvoiceDocument invoiceDocument;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;
    @Column(name = "product_amount",nullable = false)
    Float amount;
    @Column(name = "purchase_price",nullable = false)
    Float purchasePrice;
}