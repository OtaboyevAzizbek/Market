package com.market.dto.returnStoreDocument;

import com.market.entity.StoreDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReturnStoreDocumentDTO {
    StoreDocument storeDocument;
    Date date;
    String description;
}