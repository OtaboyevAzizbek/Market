package com.market.service;

import com.market.dto.organizationCalculate.CreateOrganizationCalculateDTO;
import com.market.dto.organizationCalculate.OrganizationCalculateDTO;
import com.market.dto.organizationCalculate.UpdateOrganizationCalculateDTO;

import java.util.List;

public interface OrganizationCalculateService {
    OrganizationCalculateDTO createOrganizationCalculate(CreateOrganizationCalculateDTO createOrganizationCalculateDTO);
    OrganizationCalculateDTO updateOrganizationCalculateById(Long id, UpdateOrganizationCalculateDTO updateOrganizationCalculateDTO);
    OrganizationCalculateDTO getOrganizationCalculateById(Long id);
    List<OrganizationCalculateDTO> getOrganizationCalculateList();
    void deleteOrganizationCalculateById(Long id);
}