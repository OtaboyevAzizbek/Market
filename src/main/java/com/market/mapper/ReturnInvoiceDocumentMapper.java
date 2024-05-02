package com.market.mapper;

import com.market.dto.returnInvoiceDocument.ReturnInvoiceDocumentDTO;
import com.market.entity.ReturnInvoiceDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnInvoiceDocumentMapper extends EntityMapper<ReturnInvoiceDocumentDTO, ReturnInvoiceDocument>{
}