package com.market.repository;

import com.market.entity.InvoiceDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface InvoiceDocumentRepository extends JpaRepository<InvoiceDocument,Long> {
    List<InvoiceDocument> findAllByTimestampBetween(Timestamp begin,Timestamp end);
}
