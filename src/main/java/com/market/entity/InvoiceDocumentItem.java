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
    @Column(name = "product_price",nullable = false)
    Float productPrice;
    @Column(name = "total_amount",nullable = false)
    Float totalAmount;
    @OneToMany(mappedBy = "invoiceDocumentItem",cascade = CascadeType.ALL)
    List<ReturnInvoiceDocumentItem> returnInvoiceDocumentItemList;
    @OneToMany(mappedBy = "invoiceDocumentItem",cascade = CascadeType.ALL)
    List<StoreDocumentItem> storeDocumentItemList;
}