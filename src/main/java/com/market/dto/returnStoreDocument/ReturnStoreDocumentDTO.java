package com.market.dto.returnStoreDocument;

import com.market.entity.ReturnStoreDocumentItem;
import com.market.entity.StoreDocument;
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
public class ReturnStoreDocumentDTO {
    Long id;
    StoreDocument storeDocument;
    Date date;
    String description;
    Float totalSumma;
    Timestamp timestamp;
    List<ReturnStoreDocumentItem> returnStoreDocumentItemList;
}