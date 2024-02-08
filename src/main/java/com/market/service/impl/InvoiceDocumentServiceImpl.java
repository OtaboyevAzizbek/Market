package com.market.service.impl;

import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;
import com.market.entity.InvoiceDocument;
import com.market.mapper.InvoiceDocumentMapper;
import com.market.repository.InvoiceDocumentRepository;
import com.market.service.InvoiceDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDocumentServiceImpl implements InvoiceDocumentService {

    @Autowired
    InvoiceDocumentRepository invoiceDocumentRepository;

    @Autowired
    InvoiceDocumentMapper invoiceDocumentMapper;

    @Override
    public InvoiceDocumentDTO createInvoiceDocument(CreateInvoiceDocumentDTO createInvoiceDocumentDTO) {
        InvoiceDocument invoiceDocument = new InvoiceDocument();
        invoiceDocument.setDocumentNumber(createInvoiceDocumentDTO.getDocumentNumber());
        invoiceDocument.setTimestamp(createInvoiceDocumentDTO.getTimestamp());
        invoiceDocument.setOrganization(createInvoiceDocumentDTO.getOrganization());
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.save(invoiceDocument));
    }

    @Override
    public InvoiceDocumentDTO updateInvoiceDocumentById(Long id, UpdateInvoiceDocumentDTO updateInvoiceDocumentDTO) {
        InvoiceDocument invoiceDocument = invoiceDocumentRepository.getReferenceById(id);
        invoiceDocument.setDocumentNumber(updateInvoiceDocumentDTO.getDocumentNumber());
        invoiceDocument.setTimestamp(updateInvoiceDocumentDTO.getTimestamp());
        invoiceDocument.setOrganization(updateInvoiceDocumentDTO.getOrganization());
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.save(invoiceDocument));
    }

    @Override
    public InvoiceDocumentDTO getInvoiceDocumentById(Long id) {
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.getReferenceById(id));
    }

    @Override
    public List<InvoiceDocumentDTO> getInvoiceDocumentList() {
        return invoiceDocumentMapper.toDTOs(invoiceDocumentRepository.findAll());
    }

    @Override
    public void deleteInvoiceDocumentById(Long id) {
        invoiceDocumentRepository.deleteById(id);
    }
}
