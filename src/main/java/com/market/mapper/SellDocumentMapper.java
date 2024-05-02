package com.market.mapper;

import com.market.dto.sellDocument.SellDocumentDTO;
import com.market.entity.SellDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellDocumentMapper extends EntityMapper<SellDocumentDTO, SellDocument>{
}