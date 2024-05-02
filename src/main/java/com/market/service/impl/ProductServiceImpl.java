package com.market.service.impl;

import com.market.dto.product.CreateProductDTO;
import com.market.dto.product.ProductDTO;
import com.market.dto.product.UpdateProductDTO;
import com.market.entity.Product;
import com.market.mapper.ProductMapper;
import com.market.repository.ProductRepository;
import com.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO createProduct(CreateProductDTO createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setCategory(createProductDTO.getCategory());
        product.setUnitType(createProductDTO.getUnitType());
        return productMapper.toDTO(productRepository.save(product));
    }
    @Override
    public ProductDTO updateProductById(Long id, UpdateProductDTO updateProductDTO) {
        Product product = productRepository.getReferenceById(id);
        product.setName(updateProductDTO.getName());
        product.setCategory(updateProductDTO.getCategory());
        product.setUnitType(updateProductDTO.getUnitType());
        return productMapper.toDTO(productRepository.save(product));
    }
    @Override
    public ProductDTO getProductById(Long id) {
        return productMapper.toDTO(productRepository.getReferenceById(id));
    }
    @Override
    public ProductDTO getProductByName(String name) {
        return productMapper.toDTO(productRepository.findFirstByNameEqualsIgnoreCase(name));
    }
    @Override
    public List<ProductDTO> getProductList() {
        return productMapper.toDTOs(productRepository.findAllByOrderByIdDesc());
    }
    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}