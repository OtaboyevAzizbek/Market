package com.market.dto.returnInvoiceDocument;

import com.market.entity.InvoiceDocument;
import com.market.entity.ReturnInvoiceDocumentItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReturnInvoiceDocumentDTO {
    Long id;
    InvoiceDocument invoiceDocument;
    Date date;
    String description;
    Float totalSumma;
    Timestamp timestamp;
    List<ReturnInvoiceDocumentItem> returnInvoiceDocumentItemList;
}