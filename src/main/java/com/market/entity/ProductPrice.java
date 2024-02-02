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
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_price_id")
    Long id;
    @Column(name = "product_id",nullable = false)
    Integer productId;
    @Column(name = "price",nullable = false)
    Float price;
    @Column(name = "updated_time",nullable = false)
    LocalDate localDate;
    @OneToMany(mappedBy = "price",cascade = CascadeType.ALL)
    List<Product> productList;
//    User user;  user_id
}
