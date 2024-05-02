package com.market.mapper;

import com.market.dto.returnStoreDocumentItem.ReturnStoreDocumentItemDTO;
import com.market.entity.ReturnStoreDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnStoreDocumentItemMapper extends EntityMapper<ReturnStoreDocumentItemDTO, ReturnStoreDocumentItem>{
}