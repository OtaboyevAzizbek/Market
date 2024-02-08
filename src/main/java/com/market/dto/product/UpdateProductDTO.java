package com.market.dto.product;

import com.market.entity.Category;
import com.market.entity.UnitType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductDTO {
    String name;
    UnitType unitType;
    Category category;
}
