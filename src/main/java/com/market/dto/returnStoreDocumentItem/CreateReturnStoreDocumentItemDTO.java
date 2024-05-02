package com.market.dto.returnStoreDocumentItem;

import com.market.entity.ReturnStoreDocument;
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
public class CreateReturnStoreDocumentItemDTO {
    ReturnStoreDocument storeDocument;
    StoreDocumentItem storeDocumentItem;
    Float amount;
}