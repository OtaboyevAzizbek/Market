package com.market.mapper;

import com.market.dto.invoiceDocumentItem.InvoiceDocumentItemDTO;
import com.market.entity.InvoiceDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceDocumentItemMapper extends EntityMapper<InvoiceDocumentItemDTO, InvoiceDocumentItem>{
}
