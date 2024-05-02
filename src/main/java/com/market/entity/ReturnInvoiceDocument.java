package com.market.entity;

import com.market.status.DocumentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "return_invoice_documents")
public class ReturnInvoiceDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_invoice_document_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "invoice_document_id",nullable = false)
    InvoiceDocument invoiceDocument;
    @Column(name = "date",nullable = false)
    Date date;
    @Column(name = "description",nullable = false)
    String description;
    @Column(name = "total_summa",nullable = false)
    Float totalSumma = 0.0f;
    @Column(name = "document_status",nullable = false)
    DocumentStatus documentStatus = DocumentStatus.CREATED;
    @CreationTimestamp
    @Column(name = "created_time",nullable = false,updatable = false)
    Timestamp timestamp;
    @OneToMany(mappedBy = "returnInvoiceDocument",cascade = CascadeType.ALL)
    List<ReturnInvoiceDocumentItem> returnInvoiceDocumentItemList;
}
