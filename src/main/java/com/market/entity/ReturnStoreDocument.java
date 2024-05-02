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
@Table(name = "return_store_documents")
public class ReturnStoreDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_store_document_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "store_document_id",nullable = false)
    StoreDocument storeDocument;
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
    @OneToMany(mappedBy = "storeDocument",cascade = CascadeType.ALL)
    List<ReturnStoreDocumentItem> returnStoreDocumentItemList;
}