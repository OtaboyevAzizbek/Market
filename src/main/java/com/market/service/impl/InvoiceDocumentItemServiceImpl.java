package com.market.service.impl;

import com.market.dto.invoiceDocumentItem.CreateInvoiceDocumentItemDTO;
import com.market.dto.invoiceDocumentItem.InvoiceDocumentItemDTO;
import com.market.dto.invoiceDocumentItem.UpdateInvoiceDocumentItemDTO;
import com.market.entity.InvoiceDocumentItem;
import com.market.mapper.InvoiceDocumentItemMapper;
import com.market.repository.InvoiceDocumentItemRepository;
import com.market.service.InvoiceDocumentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDocumentItemServiceImpl implements InvoiceDocumentItemService {

    @Autowired
    InvoiceDocumentItemRepository invoiceDocumentItemRepository;

    @Autowired
    InvoiceDocumentItemMapper invoiceDocumentItemMapper;

    @Override
    public InvoiceDocumentItemDTO createInvoiceDocumentItem(CreateInvoiceDocumentItemDTO createInvoiceDocumentItemDTO) {
        InvoiceDocumentItem invoiceDocumentItem = new InvoiceDocumentItem();
        invoiceDocumentItem.setInvoiceDocument(createInvoiceDocumentItemDTO.getInvoiceDocument());
        invoiceDocumentItem.setProduct(createInvoiceDocumentItemDTO.getProduct());
        invoiceDocumentItem.setAmount(createInvoiceDocumentItemDTO.getAmount());
        invoiceDocumentItem.setPurchasePrice(createInvoiceDocumentItemDTO.getPurchasePrice());
        return invoiceDocumentItemMapper.toDTO(invoiceDocumentItemRepository.save(invoiceDocumentItem));
    }

    @Override
    public InvoiceDocumentItemDTO updateInvoiceDocumentItem(Long id, UpdateInvoiceDocumentItemDTO updateInvoiceDocumentItemDTO) {
        InvoiceDocumentItem invoiceDocumentItem = invoiceDocumentItemRepository.getReferenceById(id);
        invoiceDocumentItem.setInvoiceDocument(updateInvoiceDocumentItemDTO.getInvoiceDocument());
        invoiceDocumentItem.setProduct(updateInvoiceDocumentItemDTO.getProduct());
        invoiceDocumentItem.setAmount(updateInvoiceDocumentItemDTO.getAmount());
        invoiceDocumentItem.setPurchasePrice(updateInvoiceDocumentItemDTO.getPurchasePrice());
        return invoiceDocumentItemMapper.toDTO(invoiceDocumentItemRepository.save(invoiceDocumentItem));
    }

    @Override
    public InvoiceDocumentItemDTO getInvoiceDocumentItemById(Long id) {
        return invoiceDocumentItemMapper.toDTO(invoiceDocumentItemRepository.getReferenceById(id));
    }

    @Override
    public List<InvoiceDocumentItemDTO> getInvoiceDocumentItemList() {
        return invoiceDocumentItemMapper.toDTOs(invoiceDocumentItemRepository.findAll());
    }

    @Override
    public void deleteInvoiceDocumentItemById(Long id) {
        invoiceDocumentItemRepository.deleteById(id);
    }
}
