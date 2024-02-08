package com.market.mapper;

import com.market.dto.category.CategoryDTO;
import com.market.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
}
