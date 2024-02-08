package com.market.dto.organization;

import com.market.entity.InvoiceDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

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
    List<InvoiceDocument> invoiceDocumentList;
}
