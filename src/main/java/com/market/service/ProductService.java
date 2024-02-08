package com.market.service;

import com.market.dto.product.CreateProductDTO;
import com.market.dto.product.ProductDTO;
import com.market.dto.product.UpdateProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(CreateProductDTO createProductDTO);
    ProductDTO updateProductById(Long id, UpdateProductDTO updateProductDTO);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getProductList();
    void deleteProductById(Long id);
}
