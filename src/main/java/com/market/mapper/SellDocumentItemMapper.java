package com.market.mapper;

import com.market.dto.sellDocumentItem.SellDocumentItemDTO;
import com.market.entity.SellDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellDocumentItemMapper extends EntityMapper<SellDocumentItemDTO, SellDocumentItem>{
}