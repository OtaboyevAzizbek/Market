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
@Entity
@Table(name = "unit_types")
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_type_id")
    Long id;
    @Column(name = "unit_type_name",unique = true,nullable = false)
    String name;
    @Column(name = "created_time",nullable = false,updatable = false)
    @CreationTimestamp
    Timestamp timestamp;
    @OneToMany(mappedBy = "unitType",cascade = CascadeType.ALL)
    List<Product> productList;
}
