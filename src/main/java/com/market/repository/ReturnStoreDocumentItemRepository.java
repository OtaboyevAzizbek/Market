package com.market.repository;

import com.market.entity.ReturnStoreDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnStoreDocumentItemRepository extends JpaRepository<ReturnStoreDocumentItem,Long> {
}