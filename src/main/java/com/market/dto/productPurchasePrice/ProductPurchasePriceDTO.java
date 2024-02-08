package com.market.dto.productPurchasePrice;

import com.market.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPurchasePriceDTO {
    Long id;
    Product product;
    Float price;
    Timestamp timestamp;
    Boolean status;
}
