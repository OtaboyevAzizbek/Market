package com.market.mapper;

import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.entity.InvoiceDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceDocumentMapper extends EntityMapper<InvoiceDocumentDTO, InvoiceDocument>{
}
