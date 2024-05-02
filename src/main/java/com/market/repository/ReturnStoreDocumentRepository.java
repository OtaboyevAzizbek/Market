package com.market.repository;

import com.market.entity.ReturnStoreDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnStoreDocumentRepository extends JpaRepository<ReturnStoreDocument,Long> {
}