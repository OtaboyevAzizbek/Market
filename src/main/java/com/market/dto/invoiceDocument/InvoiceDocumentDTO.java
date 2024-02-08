package com.market.dto.invoiceDocument;

import com.market.entity.InvoiceDocumentItem;
import com.market.entity.Organization;
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
public class InvoiceDocumentDTO {
    Long id;
    String documentNumber;
    Organization organization;
    Timestamp timestamp;
    List<InvoiceDocumentItem> invoiceDocumentItemList;
}
