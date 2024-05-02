package com.market.dto.returnInvoiceDocumentItem;

import com.market.entity.InvoiceDocumentItem;
import com.market.entity.ReturnInvoiceDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReturnInvoiceDocumentItemDTO {
    ReturnInvoiceDocument returnInvoiceDocument;
    InvoiceDocumentItem invoiceDocumentItem;
    Float amount;
}