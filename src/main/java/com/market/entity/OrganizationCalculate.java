package com.market.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "organization_calculate")
public class OrganizationCalculate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_calculate_id")
    Long id;
    @OneToOne
    @JoinColumn(name = "organization_id",nullable = false)
    Organization organization;
    @Column(name = "total_debt_summa",nullable = false)
    Float totalDebtSumma = 0.0f;
    @Column(name = "total_payment_summa",nullable = false)
    Float totalPaymentSumma = 0.0f;
}
