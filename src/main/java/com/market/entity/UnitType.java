package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "unit_type")
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_type_id")
    Long id;
    @Column(name = "unit_type_name",unique = true,nullable = false)
    String name;
    @OneToMany(mappedBy = "unitType",cascade = CascadeType.ALL)
    List<Product> productList;
}
