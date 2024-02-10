package com.market.service;

import com.market.dto.productPurchasePrice.CreateProductPurchasePriceDTO;
import com.market.dto.productPurchasePrice.ProductPurchasePriceDTO;
import com.market.dto.productPurchasePrice.UpdateProductPurchasePriceDTO;
import com.market.entity.Product;

import java.util.List;

public interface ProductPurchasePriceService {
    ProductPurchasePriceDTO createProductPurchasePrice(CreateProductPurchasePriceDTO createProductBuyPriceDTO);
    ProductPurchasePriceDTO updateProductPurchasePriceById(Long id, UpdateProductPurchasePriceDTO updateProductBuyPriceDTO);
    ProductPurchasePriceDTO updateProductPurchasePriceStatusByProduct(Product product);
    ProductPurchasePriceDTO getProductPurchasePriceById(Long id);
    ProductPurchasePriceDTO getProductPurchasePriceByProduct(Product product);
    List<ProductPurchasePriceDTO> getProductPurchasePriceList();
    List<ProductPurchasePriceDTO> getProductPurchaseListPriceByProductAndStatus(Product product);
    void deleteProductPurchasePriceById(Long id);
}
