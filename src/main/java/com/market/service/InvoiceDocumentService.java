package com.market.service;

import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;
import com.market.entity.Organization;

import java.sql.Date;
import java.util.List;

public interface InvoiceDocumentService {
    InvoiceDocumentDTO createInvoiceDocument(CreateInvoiceDocumentDTO createInvoiceDocumentDTO);
    InvoiceDocumentDTO updateInvoiceDocumentById(Long id, UpdateInvoiceDocumentDTO updateInvoiceDocumentDTO);
    InvoiceDocumentDTO getInvoiceDocumentById(Long id);
    InvoiceDocumentDTO getInvoiceDocumentByOrganizationAndDocumentNumberAndDate(Organization organization,String docNumber,Date date);
    List<InvoiceDocumentDTO> getInvoiceDocumentList();
    List<InvoiceDocumentDTO> getInvoiceDocumentListByOrganizationAndIntervalDate(Organization organization, Date begin, Date end);
    void deleteInvoiceDocumentById(Long id);
}