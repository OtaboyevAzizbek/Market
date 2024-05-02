package com.market.dto.storeDocument;

import com.market.entity.ReturnStoreDocument;
import com.market.entity.StoreDocumentItem;
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
public class StoreDocumentDTO {
    Long id;
    String documentNumber;
    Date date;
    Float totalSumma;
    Timestamp timestamp;
    List<StoreDocumentItem> storeDocumentItemList;
    List<ReturnStoreDocument> returnStoreDocumentList;
}