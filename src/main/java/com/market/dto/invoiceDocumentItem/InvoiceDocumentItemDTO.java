package com.market.dto.invoiceDocumentItem;

import com.market.entity.InvoiceDocument;
import com.market.entity.Product;
import com.market.entity.ReturnInvoiceDocumentItem;
import com.market.entity.StoreDocumentItem;
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
public class InvoiceDocumentItemDTO {
    Long id;
    InvoiceDocument invoiceDocument;
    Product product;
    Float amount;
    Float productPrice;
    Float totalAmount;
    List<ReturnInvoiceDocumentItem> returnInvoiceDocumentItemList;
    List<StoreDocumentItem> storeDocumentItemList;
}