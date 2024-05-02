package com.market.repository;

import com.market.entity.InvoiceDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDocumentItemRepository extends JpaRepository<InvoiceDocumentItem,Long> {
}