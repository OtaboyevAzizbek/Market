package com.market.mapper;

import com.market.dto.unitType.UnitTypeDTO;
import com.market.entity.UnitType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitTypeMapper extends EntityMapper<UnitTypeDTO, UnitType>{
}
