package com.market.service.impl;

import com.market.dto.productPurchasePrice.CreateProductPurchasePriceDTO;
import com.market.dto.productPurchasePrice.ProductPurchasePriceDTO;
import com.market.dto.productPurchasePrice.UpdateProductPurchasePriceDTO;
import com.market.entity.Product;
import com.market.entity.ProductPurchasePrice;
import com.market.mapper.ProductPurchasePriceMapper;
import com.market.repository.ProductPurchasePriceRepository;
import com.market.service.ProductPurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPurchasePriceServiceImpl implements ProductPurchasePriceService {

    @Autowired
    ProductPurchasePriceRepository productBuyPriceRepository;

    @Autowired
    ProductPurchasePriceMapper productPurchasePriceMapper;

    @Override
    public ProductPurchasePriceDTO createProductPurchasePrice(CreateProductPurchasePriceDTO createProductBuyPriceDTO) {
        ProductPurchasePrice productBuyPrice = new ProductPurchasePrice();
        productBuyPrice.setProduct(createProductBuyPriceDTO.getProduct());
        productBuyPrice.setPrice(createProductBuyPriceDTO.getPrice());
        productBuyPrice.setStatus(createProductBuyPriceDTO.getStatus());
        return productPurchasePriceMapper.toDTO(productBuyPriceRepository.save(productBuyPrice));
    }

    @Override
    public ProductPurchasePriceDTO updateProductPurchasePriceById(Long id, UpdateProductPurchasePriceDTO updateProductBuyPriceDTO) {
        ProductPurchasePrice productBuyPrice = productBuyPriceRepository.getReferenceById(id);
        productBuyPrice.setProduct(updateProductBuyPriceDTO.getProduct());
        productBuyPrice.setPrice(updateProductBuyPriceDTO.getPrice());
        productBuyPrice.setTimestamp(updateProductBuyPriceDTO.getTimestamp());
        return productPurchasePriceMapper.toDTO(productBuyPriceRepository.save(productBuyPrice));
    }

    @Override
    public ProductPurchasePriceDTO updateProductPurchasePriceStatusByProduct(Product product) {
        List<ProductPurchasePrice> productPurchasePrice = productBuyPriceRepository.findProductPurchasePricesByProduct(product);
        productPurchasePrice.get(productPurchasePrice.size()-1).setStatus(false);
        return productPurchasePriceMapper.toDTO(productBuyPriceRepository.save(productPurchasePrice.get(productPurchasePrice.size()-1)));
    }

    @Override
    public ProductPurchasePriceDTO getProductPurchasePriceById(Long id) {
        return productPurchasePriceMapper.toDTO(productBuyPriceRepository.getReferenceById(id));
    }

    @Override
    public ProductPurchasePriceDTO getProductPurchasePriceByProduct(Product product) {
        List<ProductPurchasePrice> productPurchasePrices = productBuyPriceRepository.findProductPurchasePricesByProduct(product);
        return productPurchasePriceMapper.toDTO(productPurchasePrices.get(productPurchasePrices.size()-1));
    }

    @Override
    public List<ProductPurchasePriceDTO> getProductPurchasePriceList() {
        return productPurchasePriceMapper.toDTOs(productBuyPriceRepository.findAll());
    }

    @Override
    public List<ProductPurchasePriceDTO> getProductPurchaseListPriceByProductAndStatus(Product product) {
        return productPurchasePriceMapper.toDTOs(productBuyPriceRepository.findProductPurchasePricesByProductAndStatusTrue(product));
    }

    @Override
    public void deleteProductPurchasePriceById(Long id) {
        productBuyPriceRepository.deleteById(id);
    }
}
