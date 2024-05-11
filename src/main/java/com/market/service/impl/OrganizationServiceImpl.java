package com.market.service.impl;

import com.market.dto.organization.CreateOrganizationDTO;
import com.market.dto.organization.OrganizationDTO;
import com.market.dto.organization.UpdateOrganizationDTO;
import com.market.entity.Organization;
import com.market.mapper.OrganizationMapper;
import com.market.repository.OrganizationRepository;
import com.market.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public OrganizationDTO createOrganization(CreateOrganizationDTO createOrganizationDTO) {
        Organization organization = new Organization();
        organization.setName(createOrganizationDTO.getName());
        organization.setInn(createOrganizationDTO.getInn());
        organization.setAddress(createOrganizationDTO.getAddress());
        organization.setPhoneNumber(createOrganizationDTO.getPhoneNumber());
        return organizationMapper.toDTO(organizationRepository.save(organization));
    }

    @Override
    public void updateOrganization(Long id, UpdateOrganizationDTO updateOrganizationDTO) {
        Organization organization = organizationRepository.getReferenceById(id);
        organization.setName(updateOrganizationDTO.getName());
        organization.setInn(updateOrganizationDTO.getInn());
        organization.setPhoneNumber(updateOrganizationDTO.getPhoneNumber());
        organization.setAddress(updateOrganizationDTO.getAddress());
        organizationMapper.toDTO(organizationRepository.save(organization));
    }

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        return organizationMapper.toDTO(organizationRepository.getReferenceById(id));
    }

    @Override
    public OrganizationDTO getOrganizationByNameAndInn(String name, String inn) {
        return organizationMapper.toDTO(organizationRepository.findFirstByNameEqualsIgnoreCaseOrInnEqualsIgnoreCase(name, inn));
    }

    @Override
    public List<OrganizationDTO> getDeletedOrganizationList() {
        return organizationMapper.toDTOs(organizationRepository.findAllByDeletedTimeIsNotNullOrderByIdDesc());
    }

    @Override
    public List<OrganizationDTO> getUndeletedOrganizationList() {
        return organizationMapper.toDTOs(organizationRepository.findAllByDeletedTimeIsNullOrderByIdDesc());
    }

    @Override
    public void deleteOrganizationById(Long id) {
        Organization organization = organizationRepository.getReferenceById(id);
        organization.setDeletedTime(Timestamp.valueOf(LocalDateTime.now()));
        organizationRepository.save(organization);
    }

    @Override
    public void restoreOrganizationById(Long id) {
        Organization organization = organizationRepository.getReferenceById(id);
        organization.setDeletedTime(null);
        organizationRepository.save(organization);
    }
}