package com.market.mapper;

import com.market.dto.productPurchasePrice.ProductPurchasePriceDTO;
import com.market.entity.ProductPurchasePrice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPurchasePriceMapper extends EntityMapper<ProductPurchasePriceDTO, ProductPurchasePrice>{
}
