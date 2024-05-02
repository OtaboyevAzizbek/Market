package com.market.repository;

import com.market.entity.ReturnInvoiceDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnInvoiceDocumentRepository extends JpaRepository<ReturnInvoiceDocument,Long> {
}