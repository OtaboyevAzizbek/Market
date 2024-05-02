package com.market.repository;

import com.market.entity.OrganizationCalculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationCalculateRepository extends JpaRepository<OrganizationCalculate,Long> {
}