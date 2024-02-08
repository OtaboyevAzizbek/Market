package com.market.service;

import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;

import java.util.List;

public interface InvoiceDocumentService {
    InvoiceDocumentDTO createInvoiceDocument(CreateInvoiceDocumentDTO createInvoiceDocumentDTO);
    InvoiceDocumentDTO updateInvoiceDocumentById(Long id, UpdateInvoiceDocumentDTO updateInvoiceDocumentDTO);
    InvoiceDocumentDTO getInvoiceDocumentById(Long id);
    List<InvoiceDocumentDTO> getInvoiceDocumentList();
    void deleteInvoiceDocumentById(Long id);
}
