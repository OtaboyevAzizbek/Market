package com.market.mapper;

import com.market.dto.productPriceHistory.ProductPriceHistoryDTO;
import com.market.entity.ProductPriceHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPriceHistoryMapper extends EntityMapper<ProductPriceHistoryDTO,ProductPriceHistory>{
}