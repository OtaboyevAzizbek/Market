package com.market.mapper;

import com.market.dto.returnInvoiceDocumentItem.ReturnInvoiceDocumentItemDTO;
import com.market.entity.ReturnInvoiceDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnInvoiceDocumentItemMapper extends EntityMapper<ReturnInvoiceDocumentItemDTO, ReturnInvoiceDocumentItem>{
}