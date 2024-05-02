package com.market.service.impl;

import com.market.dto.organizationCalculate.CreateOrganizationCalculateDTO;
import com.market.dto.organizationCalculate.OrganizationCalculateDTO;
import com.market.dto.organizationCalculate.UpdateOrganizationCalculateDTO;
import com.market.entity.OrganizationCalculate;
import com.market.mapper.OrganizationCalculateMapper;
import com.market.repository.OrganizationCalculateRepository;
import com.market.service.OrganizationCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationCalculateServiceImpl implements OrganizationCalculateService {

    @Autowired
    OrganizationCalculateRepository organizationCalculateRepository;

    @Autowired
    OrganizationCalculateMapper organizationCalculateMapper;

    @Override
    public OrganizationCalculateDTO createOrganizationCalculate(CreateOrganizationCalculateDTO createOrganizationCalculateDTO) {
        OrganizationCalculate organizationCalculate = new OrganizationCalculate();
        organizationCalculate.setOrganization(createOrganizationCalculateDTO.getOrganization());
        return organizationCalculateMapper.toDTO(organizationCalculateRepository.save(organizationCalculate));
    }

    @Override
    public OrganizationCalculateDTO updateOrganizationCalculateById(Long id, UpdateOrganizationCalculateDTO updateOrganizationCalculateDTO) {
        OrganizationCalculate organizationCalculate = organizationCalculateRepository.getReferenceById(id);
        organizationCalculate.setOrganization(organizationCalculate.getOrganization());
        organizationCalculate.setTotalDebtSumma(organizationCalculate.getTotalDebtSumma());
        organizationCalculate.setTotalPaymentSumma(organizationCalculate.getTotalPaymentSumma());
        return organizationCalculateMapper.toDTO(organizationCalculateRepository.save(organizationCalculate));
    }

    @Override
    public OrganizationCalculateDTO getOrganizationCalculateById(Long id) {
        return organizationCalculateMapper.toDTO(organizationCalculateRepository.getReferenceById(id));
    }

    @Override
    public List<OrganizationCalculateDTO> getOrganizationCalculateList() {
        return organizationCalculateMapper.toDTOs(organizationCalculateRepository.findAll());
    }

    @Override
    public void deleteOrganizationCalculateById(Long id) {
        organizationCalculateRepository.deleteById(id);
    }
}
