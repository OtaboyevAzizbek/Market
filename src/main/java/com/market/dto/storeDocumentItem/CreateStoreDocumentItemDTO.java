package com.market.dto.storeDocumentItem;

import com.market.entity.InvoiceDocumentItem;
import com.market.entity.StoreDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStoreDocumentItemDTO {
    StoreDocument storeDocument;
    Float amount;
    Float totalAmount;
    InvoiceDocumentItem invoiceDocumentItem;
}