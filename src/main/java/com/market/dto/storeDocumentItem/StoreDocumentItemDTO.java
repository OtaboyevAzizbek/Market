package com.market.dto.storeDocumentItem;

import com.market.entity.InvoiceDocumentItem;
import com.market.entity.ReturnStoreDocumentItem;
import com.market.entity.SellDocumentItem;
import com.market.entity.StoreDocument;
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
public class StoreDocumentItemDTO {
    Long id;
    StoreDocument storeDocument;
    Float amount;
    Float totalAmount;
    InvoiceDocumentItem invoiceDocumentItem;
    List<ReturnStoreDocumentItem> returnStoreDocumentItemList;
    List<SellDocumentItem> sellDocumentItemList;
}