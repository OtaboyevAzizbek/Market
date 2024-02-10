package com.market.repository;

import com.market.entity.Product;
import com.market.entity.ProductSellPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSellPriceRepository extends JpaRepository<ProductSellPrice,Long> {
    List<ProductSellPrice> findProductSellPricesByProduct(Product product);
    List<ProductSellPrice> findProductSellPricesByProductAndStatusTrue(Product product);
}
