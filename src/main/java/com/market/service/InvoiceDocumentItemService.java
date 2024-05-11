package com.market.service;

import com.market.dto.invoiceDocumentItem.CreateInvoiceDocumentItemDTO;
import com.market.dto.invoiceDocumentItem.InvoiceDocumentItemDTO;

import java.util.List;

public interface InvoiceDocumentItemService {
    void createInvoiceDocumentItem(CreateInvoiceDocumentItemDTO createInvoiceDocumentItemDTO);
//    InvoiceDocumentItemDTO updateInvoiceDocumentItem(Long id, UpdateInvoiceDocumentItemDTO updateInvoiceDocumentItemDTO);
    InvoiceDocumentItemDTO getInvoiceDocumentItemById(Long id);
    List<InvoiceDocumentItemDTO> getInvoiceDocumentItemList();
    void deleteInvoiceDocumentItemById(Long id);
}
