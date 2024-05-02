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
@Table(name = "invoice_documents",uniqueConstraints = @UniqueConstraint(columnNames = {"invoice_document_number","organization_id","date"}))
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
    @Column(name = "date",nullable = false)
    Date date;
    @Column(name = "total_summa",nullable = false)
    Float totalSumma = 0.0f;
    @Column(name = "document_status",nullable = false)
    DocumentStatus documentStatus = DocumentStatus.CREATED;
    @CreationTimestamp
    @Column(name = "created_time",nullable = false,updatable = false)
    Timestamp timestamp;
    @OneToMany(mappedBy = "invoiceDocument",cascade = CascadeType.ALL)
    List<InvoiceDocumentItem> invoiceDocumentItemList;
    @OneToMany(mappedBy = "invoiceDocument",cascade = CascadeType.ALL)
    List<ReturnInvoiceDocument> returnInvoiceDocumentList;
}