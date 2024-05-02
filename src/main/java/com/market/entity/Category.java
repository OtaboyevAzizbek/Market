package com.market.entity;

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
@Entity @Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Long id;
    @Column(name = "category_name",nullable = false,unique = true)
    String name;
    @Column(name = "created_time",nullable = false,updatable = false)
    @CreationTimestamp
    Timestamp timestamp;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    List<Product> productList;
}
