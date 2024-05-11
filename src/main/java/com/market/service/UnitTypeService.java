package com.market.service;

import com.market.dto.unitType.CreateUnitTypeDTO;
import com.market.dto.unitType.UnitTypeDTO;
import com.market.dto.unitType.UpdateUnitTypeDTO;

import java.util.List;

public interface UnitTypeService {
    void createUnitType(CreateUnitTypeDTO createUnitTypeDTO);

    void updateUnitType(Long id, UpdateUnitTypeDTO updateUnitTypeDTO);

    UnitTypeDTO getUnitTypeByName(String name);

    List<UnitTypeDTO> getUnitTypeList();

    void deleteUnitTypeById(Long id);
}