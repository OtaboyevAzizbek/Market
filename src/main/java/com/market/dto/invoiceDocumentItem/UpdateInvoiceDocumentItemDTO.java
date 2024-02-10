package com.market.dto.invoiceDocumentItem;

import com.market.entity.InvoiceDocument;
import com.market.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateInvoiceDocumentItemDTO {
    InvoiceDocument invoiceDocument;
    Product product;
    Float amount;
    Float purchasePrice;
}
