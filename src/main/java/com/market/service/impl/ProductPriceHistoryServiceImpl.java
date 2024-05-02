package com.market.service.impl;

import com.market.dto.productPriceHistory.CreateProductPriceHistoryDTO;
import com.market.dto.productPriceHistory.ProductPriceHistoryDTO;
import com.market.entity.Product;
import com.market.entity.ProductPriceHistory;
import com.market.mapper.ProductPriceHistoryMapper;
import com.market.repository.ProductPriceHistoryRepository;
import com.market.service.ProductPriceHistoryService;
import com.market.status.ProductPriceStatus;
import com.market.status.ProductPriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPriceHistoryServiceImpl implements ProductPriceHistoryService {

    @Autowired
    ProductPriceHistoryRepository productPriceHistoryRepository;

    @Autowired
    ProductPriceHistoryMapper productPriceHistoryMapper;

    @Override
    public ProductPriceHistoryDTO createProductPriceHistory(CreateProductPriceHistoryDTO createProductPriceHistoryDTO) {
        ProductPriceHistory productPriceHistory = new ProductPriceHistory();
        productPriceHistory.setProduct(createProductPriceHistoryDTO.getProduct());
        productPriceHistory.setProductPriceType(createProductPriceHistoryDTO.getProductPriceType());
        productPriceHistory.setPrice(createProductPriceHistoryDTO.getPrice());
        productPriceHistory.setProductPriceStatus(createProductPriceHistoryDTO.getProductPriceStatus());
        return productPriceHistoryMapper.toDTO(productPriceHistoryRepository.save(productPriceHistory));
    }

    @Override
    public ProductPriceHistoryDTO updateProductPriceHistoryById(Long id, ProductPriceStatus productPriceStatus) {
        ProductPriceHistory productPriceHistory = productPriceHistoryRepository.getReferenceById(id);
        productPriceHistory.setProductPriceStatus(productPriceStatus);
        return productPriceHistoryMapper.toDTO(productPriceHistoryRepository.save(productPriceHistory));
    }

    @Override
    public List<ProductPriceHistoryDTO> getProductPriceHistoryListByProductAndProductPriceType(Product product, ProductPriceType productPriceType) {
        return productPriceHistoryMapper.toDTOs(productPriceHistoryRepository.findAllByProductAndAndProductPriceType(product, productPriceType));
    }

    @Override
    public ProductPriceHistoryDTO getProductPriceHistoryByProductAndProductPriceType(Product product, ProductPriceType productPriceType, ProductPriceStatus productPriceStatus) {
        return productPriceHistoryMapper.toDTO(productPriceHistoryRepository.findFirstByProductAndProductPriceTypeAndProductPriceStatus(product, productPriceType, productPriceStatus));
    }
}