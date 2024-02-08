package com.market.service;

import com.market.dto.unitType.CreateUnitTypeDTO;
import com.market.dto.unitType.UnitTypeDTO;
import com.market.dto.unitType.UpdateUnitTypeDTO;

import java.util.List;

public interface UnitTypeService {
    UnitTypeDTO createUnitType(CreateUnitTypeDTO createUnitTypeDTO);
    UnitTypeDTO updateUnitType(Long id, UpdateUnitTypeDTO updateUnitTypeDTO);
    UnitTypeDTO getUnitTypeById(Long id);
    List<UnitTypeDTO> getUnitTypeList();
    void deleteUnitTypeById(Long id);
}
