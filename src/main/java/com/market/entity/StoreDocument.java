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
@Table(name = "store_documents")
public class StoreDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_document_id")
    Long id;
    @Column(name = "store_document_number",nullable = false,unique = true)
    String documentNumber;
    @Column(name = "date",nullable = false)
    Date date;
    @Column(name = "total_summa",nullable = false)
    Float totalSumma = 0.0f;
    @Column(name = "document_status",nullable = false)
    DocumentStatus documentStatus = DocumentStatus.CREATED;
    @CreationTimestamp
    @Column(name = "created_time",nullable = false,updatable = false)
    Timestamp timestamp;
    @OneToMany(mappedBy = "storeDocument",cascade = CascadeType.ALL)
    List<StoreDocumentItem> storeDocumentItemList;
    @OneToMany(mappedBy = "storeDocument",cascade = CascadeType.ALL)
    List<ReturnStoreDocument> returnStoreDocumentList;
}
