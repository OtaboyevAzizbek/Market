package com.market.dto.productPurchasePrice;

import com.market.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductPurchasePriceDTO {
    Product product;
    Float price;
    Boolean status;
}
