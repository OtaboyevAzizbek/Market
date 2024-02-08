package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "invoice_documents")
public class InvoiceDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_document_id")
    Long id;
    @Column(name = "invoice_document_number",nullable = false)
    String documentNumber;
    @ManyToOne
    @JoinColumn(name = "organization_id",nullable = false)
    Organization organization;
    @Column(name = "created_date")
    Timestamp timestamp;
    @OneToMany(mappedBy = "invoiceDocument",cascade = CascadeType.ALL)
    List<InvoiceDocumentItem> invoiceDocumentItemList;
}
