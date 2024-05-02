package com.market.service;

import com.market.dto.organization.CreateOrganizationDTO;
import com.market.dto.organization.OrganizationDTO;
import com.market.dto.organization.UpdateOrganizationDTO;

import java.util.List;

public interface OrganizationService {
    OrganizationDTO createOrganization(CreateOrganizationDTO createOrganizationDTO);
    OrganizationDTO updateOrganization(Long id, UpdateOrganizationDTO updateOrganizationDTO);
    OrganizationDTO getOrganizationById(Long id);
    OrganizationDTO getOrganizationByName(String name);
    List<OrganizationDTO> getOrganizationList();
    void deleteOrganizationById(Long id);
}
