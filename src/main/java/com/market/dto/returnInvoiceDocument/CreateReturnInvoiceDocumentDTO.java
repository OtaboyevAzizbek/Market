package com.market.dto.returnInvoiceDocument;

import com.market.entity.InvoiceDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReturnInvoiceDocumentDTO {
    InvoiceDocument invoiceDocument;
    Date date;
    String description;
}