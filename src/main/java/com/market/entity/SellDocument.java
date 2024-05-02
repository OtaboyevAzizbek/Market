package com.market.entity;

import com.market.status.DocumentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "sell_documents")
public class SellDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_document_id")
    Long id;
    @Column(name = "sell_document_number",nullable = false,unique = true)
    String documentNumber;
    @Column(name = "total_summa",nullable = false)
    Float totalSumma = 0.0f;
    @Column(name = "document_status",nullable = false)
    DocumentStatus documentStatus = DocumentStatus.CREATED;
    @CreationTimestamp
    @Column(name = "created_time",nullable = false,updatable = false)
    Timestamp timestamp;
    @OneToMany(mappedBy = "sellDocument",cascade = CascadeType.ALL)
    List<SellDocumentItem> sellDocumentItemList;
}