package com.market.repository;

import com.market.entity.ReturnInvoiceDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnInvoiceDocumentItemRepository extends JpaRepository<ReturnInvoiceDocumentItem,Long> {
}