package com.market.entity;

import com.market.status.ProductPriceStatus;
import com.market.status.ProductPriceType;
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
@Table(name = "product_price_history")
public class ProductPriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_price_history_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;
    @Column(name = "product_price",nullable = false)
    Float price;
    @CreationTimestamp
    @Column(name = "updated_date",nullable = false,updatable = false)
    Timestamp timestamp;
    @Enumerated(EnumType.STRING)
    @Column(name = "price_history_type",nullable = false)
    ProductPriceType productPriceType;
    @Enumerated(EnumType.STRING)
    @Column(name = "price_history_status",nullable = false)
    ProductPriceStatus productPriceStatus;
}
