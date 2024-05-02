package com.market.mapper;

import com.market.dto.storeDocument.StoreDocumentDTO;
import com.market.entity.StoreDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreDocumentMapper extends EntityMapper<StoreDocumentDTO, StoreDocument>{
}