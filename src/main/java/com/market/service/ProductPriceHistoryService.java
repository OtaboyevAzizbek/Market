package com.market.service;

import com.market.dto.productPriceHistory.CreateProductPriceHistoryDTO;
import com.market.dto.productPriceHistory.ProductPriceHistoryDTO;
import com.market.entity.Product;
import com.market.status.ProductPriceStatus;
import com.market.status.ProductPriceType;

import java.util.List;

public interface ProductPriceHistoryService {
    void createProductPriceHistory(CreateProductPriceHistoryDTO createProductPriceHistoryDTO);
    void updateProductPriceHistoryById(Long id, ProductPriceStatus productPriceStatus);
    List<ProductPriceHistoryDTO> getProductPriceHistoryListByProductAndProductPriceType(Product product, ProductPriceType productPriceType);
    ProductPriceHistoryDTO getProductPriceHistoryByProductAndProductPriceType(Product product, ProductPriceType productPriceType, ProductPriceStatus productPriceStatus);
}