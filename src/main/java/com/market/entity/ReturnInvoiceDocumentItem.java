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
@Table(name = "return_invoice_document_items")
public class ReturnInvoiceDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_invoice_document_item_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "return_invoice_document_id",nullable = false)
    ReturnInvoiceDocument returnInvoiceDocument;
    @ManyToOne
    @JoinColumn(name = "invoice_document_item_id",nullable = false)
    InvoiceDocumentItem invoiceDocumentItem;
    @Column(name = "product_amount",nullable = false)
    Float amount;
}