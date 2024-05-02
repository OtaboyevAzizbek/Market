package com.market.mapper;

import com.market.dto.storeDocumentItem.StoreDocumentItemDTO;
import com.market.entity.StoreDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreDocumentItemMapper extends EntityMapper<StoreDocumentItemDTO, StoreDocumentItem>{
}