package com.market.dto.organizationCalculate;

import com.market.entity.Organization;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrganizationCalculateDTO {
    Long id;
    Organization organization;
    Float totalDebtSumma;
    Float totalPaymentSumma;
}