package com.market.service.impl;

import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;
import com.market.entity.InvoiceDocument;
import com.market.entity.Organization;
import com.market.mapper.InvoiceDocumentMapper;
import com.market.repository.InvoiceDocumentRepository;
import com.market.service.InvoiceDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
        invoiceDocument.setOrganization(createInvoiceDocumentDTO.getOrganization());
        invoiceDocument.setDate(createInvoiceDocumentDTO.getDate());
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.save(invoiceDocument));
    }
    @Override
    public InvoiceDocumentDTO updateInvoiceDocumentById(Long id, UpdateInvoiceDocumentDTO updateInvoiceDocumentDTO) {
        InvoiceDocument invoiceDocument = invoiceDocumentRepository.getReferenceById(id);
        invoiceDocument.setDocumentNumber(updateInvoiceDocumentDTO.getDocumentNumber());
        invoiceDocument.setOrganization(updateInvoiceDocumentDTO.getOrganization());
        invoiceDocument.setDate(updateInvoiceDocumentDTO.getDate());
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.save(invoiceDocument));
    }
    @Override
    public InvoiceDocumentDTO getInvoiceDocumentById(Long id) {
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.getReferenceById(id));
    }
    @Override
    public InvoiceDocumentDTO getInvoiceDocumentByOrganizationAndDocumentNumberAndDate(Organization organization, String docNumber, Date date) {
        return invoiceDocumentMapper.toDTO(invoiceDocumentRepository.findFirstByOrganizationAndDocumentNumberAndDate(organization,docNumber,date));
    }
    @Override
    public List<InvoiceDocumentDTO> getInvoiceDocumentList() {
        return invoiceDocumentMapper.toDTOs(invoiceDocumentRepository.findAllByOrderByIdDesc());
    }
    @Override
    public List<InvoiceDocumentDTO> getInvoiceDocumentListByOrganizationAndIntervalDate(Organization organization, Date begin, Date end) {
        return invoiceDocumentMapper.toDTOs(invoiceDocumentRepository.findAllByOrganizationAndDateBetween(organization,begin,end));
    }
    @Override
    public void deleteInvoiceDocumentById(Long id) {
        invoiceDocumentRepository.deleteById(id);
    }
}