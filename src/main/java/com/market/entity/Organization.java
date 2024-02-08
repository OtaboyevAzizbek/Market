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
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    Long id;
    @Column(name = "organization_name",nullable = false,unique = true)
    String name;
    @Column(name = "organization_address",nullable = false)
    String address;
    @Column(name = "phone_number",nullable = false)
    String phoneNumber;
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
    List<InvoiceDocument> invoiceDocumentList;
}
