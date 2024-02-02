package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_document")
public class ProductDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_document_id")
    Long id;
    @Column(name = "document_number",nullable = false)
    String documentNumber;
    @ManyToOne
    @JoinColumn(name = "organization_id",nullable = false)
    Organization organization;
    @Column(name = "created_time",nullable = false)
    LocalDate localDate;
    @OneToMany(mappedBy = "productDocument",cascade = CascadeType.ALL)
    List<ProductDocumentItem> productDocumentItemList;
}
