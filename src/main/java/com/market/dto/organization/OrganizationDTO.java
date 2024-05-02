package com.market.dto.organization;

import com.market.entity.InvoiceDocument;
import com.market.entity.OrganizationCalculate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrganizationDTO {
    Long id;
    String name;
    String address;
    String phoneNumber;
    Timestamp timestamp;
    Timestamp deletedTime;
    OrganizationCalculate organizationCalculate;
    List<InvoiceDocument> invoiceDocumentList;
}
