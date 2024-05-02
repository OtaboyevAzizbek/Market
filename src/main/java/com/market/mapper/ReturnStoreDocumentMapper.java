package com.market.mapper;

import com.market.dto.returnStoreDocument.ReturnStoreDocumentDTO;
import com.market.entity.ReturnStoreDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnStoreDocumentMapper extends EntityMapper<ReturnStoreDocumentDTO, ReturnStoreDocument>{
}