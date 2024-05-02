package com.market.repository;

import com.market.entity.Product;
import com.market.entity.ProductPriceHistory;
import com.market.status.ProductPriceStatus;
import com.market.status.ProductPriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceHistoryRepository extends JpaRepository<ProductPriceHistory,Long> {
    ProductPriceHistory findFirstByProductAndProductPriceTypeAndProductPriceStatus(Product product, ProductPriceType productPriceType, ProductPriceStatus productPriceStatus);
    List<ProductPriceHistory> findAllByProductAndAndProductPriceType(Product product,ProductPriceType productPriceType);
}