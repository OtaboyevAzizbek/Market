package com.market.repository;

import com.market.entity.StoreDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDocumentItemRepository extends JpaRepository<StoreDocumentItem,Long> {
}