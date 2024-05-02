package com.market.dto.category;

import com.market.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    Long id;
    String name;
    Timestamp createdTime;
    List<Product> productList;
}
