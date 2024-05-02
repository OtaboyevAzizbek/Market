package com.market.repository;

import com.market.entity.InvoiceDocument;
import com.market.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface InvoiceDocumentRepository extends JpaRepository<InvoiceDocument,Long> {
    List<InvoiceDocument> findAllByOrganizationAndDateBetween(Organization organization, Date begin, Date end);
    List<InvoiceDocument> findAllByOrderByIdDesc();
    InvoiceDocument findFirstByOrganizationAndDocumentNumberAndDate(Organization organization,String docNumber,Date date);
}