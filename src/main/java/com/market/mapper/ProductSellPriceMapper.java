package com.market.mapper;

import com.market.dto.productSellPrice.ProductSellPriceDTO;
import com.market.entity.ProductSellPrice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSellPriceMapper extends EntityMapper<ProductSellPriceDTO, ProductSellPrice>{
}
