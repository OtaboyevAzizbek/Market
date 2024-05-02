package com.market.dto.productPriceHistory;

import com.market.entity.Product;
import com.market.status.ProductPriceStatus;
import com.market.status.ProductPriceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductPriceHistoryDTO {
    Product product;
    Float price;
    ProductPriceType productPriceType;
    ProductPriceStatus productPriceStatus;
}