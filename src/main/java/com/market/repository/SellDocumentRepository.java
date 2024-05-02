package com.market.repository;

import com.market.entity.SellDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocumentRepository extends JpaRepository<SellDocument,Long> {
}