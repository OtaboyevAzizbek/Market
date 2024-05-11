package com.market.service.impl;

import com.market.dto.unitType.CreateUnitTypeDTO;
import com.market.dto.unitType.UnitTypeDTO;
import com.market.dto.unitType.UpdateUnitTypeDTO;
import com.market.entity.UnitType;
import com.market.mapper.UnitTypeMapper;
import com.market.repository.UnitTypeRepository;
import com.market.service.UnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {
    private final UnitTypeRepository unitTypeRepository;
    private final UnitTypeMapper unitTypeMapper;

    @Override
    public void createUnitType(CreateUnitTypeDTO createUnitTypeDTO) {
        UnitType unitType = new UnitType();
        unitType.setName(createUnitTypeDTO.getName());
        unitTypeMapper.toDTO(unitTypeRepository.save(unitType));
    }

    @Override
    public void updateUnitType(Long id, UpdateUnitTypeDTO updateUnitTypeDTO) {
        UnitType unitType = unitTypeRepository.getReferenceById(id);
        unitType.setName(updateUnitTypeDTO.getName());
        unitTypeMapper.toDTO(unitTypeRepository.save(unitType));
    }

    @Override
    public UnitTypeDTO getUnitTypeByName(String name) {
        return unitTypeMapper.toDTO(unitTypeRepository.findFirstByNameEqualsIgnoreCase(name));
    }

    @Override
    public List<UnitTypeDTO> getUnitTypeList() {
        return unitTypeMapper.toDTOs(unitTypeRepository.findAllByOrderByIdDesc());
    }

    @Override
    public void deleteUnitTypeById(Long id) {
        unitTypeRepository.deleteById(id);
    }
}
