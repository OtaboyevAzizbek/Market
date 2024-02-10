package com.market.service.impl;

import com.market.dto.productSellPrice.CreateProductSellPriceDTO;
import com.market.dto.productSellPrice.ProductSellPriceDTO;
import com.market.dto.productSellPrice.UpdateProductSellPriceDTO;
import com.market.entity.Product;
import com.market.entity.ProductSellPrice;
import com.market.mapper.ProductSellPriceMapper;
import com.market.repository.ProductSellPriceRepository;
import com.market.service.ProductSellPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSellPriceServiceImpl implements ProductSellPriceService {

    @Autowired
    ProductSellPriceRepository productSellPriceRepository;

    @Autowired
    ProductSellPriceMapper productSellPriceMapper;

    @Override
    public ProductSellPriceDTO createProductSellPrice(CreateProductSellPriceDTO createProductSellPriceDTO) {
        ProductSellPrice productSellPrice = new ProductSellPrice();
        productSellPrice.setProduct(createProductSellPriceDTO.getProduct());
        productSellPrice.setPrice(createProductSellPriceDTO.getPrice());
        productSellPrice.setStatus(createProductSellPriceDTO.getStatus());
        return productSellPriceMapper.toDTO(productSellPriceRepository.save(productSellPrice));
    }

    @Override
    public ProductSellPriceDTO updateProductSellPriceById(Long id, UpdateProductSellPriceDTO updateProductSellPriceDTO) {
        ProductSellPrice productSellPrice = productSellPriceRepository.getReferenceById(id);
        productSellPrice.setProduct(updateProductSellPriceDTO.getProduct());
        productSellPrice.setPrice(updateProductSellPriceDTO.getPrice());
        productSellPrice.setTimestamp(updateProductSellPriceDTO.getTimestamp());
        return productSellPriceMapper.toDTO(productSellPriceRepository.save(productSellPrice));
    }

    @Override
    public ProductSellPriceDTO updateProductSellPriceStatusByProduct(Product product) {
        List<ProductSellPrice> productSellPrices = productSellPriceRepository.findProductSellPricesByProduct(product);
        productSellPrices.get(productSellPrices.size()-1).setStatus(false);
        return productSellPriceMapper.toDTO(productSellPriceRepository.save(productSellPrices.get(productSellPrices.size()-1)));
    }

    @Override
    public ProductSellPriceDTO getProductSellPriceById(Long id) {
        return productSellPriceMapper.toDTO(productSellPriceRepository.getReferenceById(id));
    }

    @Override
    public ProductSellPriceDTO getProductSellPriceByProduct(Product product) {
        List<ProductSellPrice> productSellPrices = productSellPriceRepository.findProductSellPricesByProduct(product);
        return productSellPriceMapper.toDTO(productSellPrices.get(productSellPrices.size()-1));
    }

    @Override
    public List<ProductSellPriceDTO> getProductSellPriceListByProductAndStatus(Product product) {
        return productSellPriceMapper.toDTOs(productSellPriceRepository.findProductSellPricesByProductAndStatusTrue(product));
    }

    @Override
    public List<ProductSellPriceDTO> getProductSellPriceList() {
        return productSellPriceMapper.toDTOs(productSellPriceRepository.findAll());
    }

    @Override
    public void deleteProductSellPriceById(Long id) {
        productSellPriceRepository.deleteById(id);
    }
}
