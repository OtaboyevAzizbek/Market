package com.market.repository;

import com.market.entity.Product;
import com.market.entity.ProductPurchasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPurchasePriceRepository extends JpaRepository<ProductPurchasePrice,Long> {
    List<ProductPurchasePrice> findProductPurchasePricesByProduct(Product product);
    List<ProductPurchasePrice> findProductPurchasePricesByProductAndStatusTrue(Product product);
}
