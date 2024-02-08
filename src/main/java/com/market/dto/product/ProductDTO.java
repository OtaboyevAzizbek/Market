package com.market.dto.product;

import com.market.entity.*;
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
public class ProductDTO {
    Long id;
    String name;
    UnitType unitType;
    Category category;
    Float totalAmount;
    List<ProductPurchasePrice> productPurchasePriceList;
    List<ProductSellPrice> productSellPriceList;
    List<InvoiceDocumentItem> invoiceDocumentItemList;
}