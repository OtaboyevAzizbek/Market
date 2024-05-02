package com.market.mapper;

import com.market.dto.product.ProductDTO;
import com.market.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product>{
}