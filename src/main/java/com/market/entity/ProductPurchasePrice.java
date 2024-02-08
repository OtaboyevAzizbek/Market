package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_purchase_price")
public class ProductPurchasePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_purchase_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;
    @Column(name = "product_price",nullable = false)
    Float price;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    Timestamp timestamp;
    @Column(name = "status",nullable = false,columnDefinition = "BOOLEAN DEFAULT true")
    Boolean status;
}
