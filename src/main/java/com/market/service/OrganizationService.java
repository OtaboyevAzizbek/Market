package com.market.service;

import com.market.dto.organization.CreateOrganizationDTO;
import com.market.dto.organization.OrganizationDTO;
import com.market.dto.organization.UpdateOrganizationDTO;

import java.util.List;

public interface OrganizationService {
    OrganizationDTO createOrganization(CreateOrganizationDTO createOrganizationDTO);

    void updateOrganization(Long id, UpdateOrganizationDTO updateOrganizationDTO);

    OrganizationDTO getOrganizationById(Long id);

    OrganizationDTO getOrganizationByNameAndInn(String name, String inn);

    List<OrganizationDTO> getDeletedOrganizationList();

    List<OrganizationDTO> getUndeletedOrganizationList();

    void deleteOrganizationById(Long id);

    void restoreOrganizationById(Long id);
}