package com.market.mapper;

import com.market.dto.organization.OrganizationDTO;
import com.market.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<OrganizationDTO, Organization>{
}
