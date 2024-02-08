package com.market.service;

import com.market.dto.productSellPrice.CreateProductSellPriceDTO;
import com.market.dto.productSellPrice.ProductSellPriceDTO;
import com.market.dto.productSellPrice.UpdateProductSellPriceDTO;
import com.market.entity.Product;

import java.util.List;

public interface ProductSellPriceService {
    ProductSellPriceDTO createProductSellPrice(CreateProductSellPriceDTO createProductSellPriceDTO);
    ProductSellPriceDTO updateProductSellPriceById(Long id, UpdateProductSellPriceDTO updateProductSellPriceDTO);
    ProductSellPriceDTO updateProductSellPriceStatusByProduct(Product product);
    ProductSellPriceDTO getProductSellPriceById(Long id);
    ProductSellPriceDTO getProductSellPriceByProduct(Product product);
    List<ProductSellPriceDTO> getProductSellPriceList();
    void deleteProductSellPriceById(Long id);
}
