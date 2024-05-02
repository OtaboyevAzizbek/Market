package com.market.mapper;

import com.market.dto.organizationCalculate.OrganizationCalculateDTO;
import com.market.entity.OrganizationCalculate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationCalculateMapper extends EntityMapper<OrganizationCalculateDTO, OrganizationCalculate>{
}