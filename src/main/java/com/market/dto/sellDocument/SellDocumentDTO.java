package com.market.dto.sellDocument;

import com.market.entity.SellDocumentItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellDocumentDTO {
    Long id;
    String documentNumber;
    Float totalSumma;
    Timestamp timestamp;
    List<SellDocumentItem> sellDocumentItemList;
}