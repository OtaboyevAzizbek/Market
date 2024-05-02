package com.market.repository;

import com.market.entity.SellDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocumentItemRepository extends JpaRepository<SellDocumentItem,Long> {
}