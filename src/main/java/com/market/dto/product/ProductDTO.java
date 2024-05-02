package com.market.dto.product;

import com.market.entity.Category;
import com.market.entity.InvoiceDocumentItem;
import com.market.entity.ProductPriceHistory;
import com.market.entity.UnitType;
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
    Float storeAmount;
    Float warehouseAmount;
    Float buyPrice;
    Float sellPrice;
    List<ProductPriceHistory> productPriceHistoryList;
    List<InvoiceDocumentItem> productDocumentItemList;
}