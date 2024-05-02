package com.market.dto.sellDocumentItem;

import com.market.entity.SellDocument;
import com.market.entity.StoreDocumentItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellDocumentItemDTO {
    Long id;
    SellDocument sellDocument;
    StoreDocumentItem storeDocumentItem;
    Float amount;
    Float productPrice;
}