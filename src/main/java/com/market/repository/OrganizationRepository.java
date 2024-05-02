package com.market.repository;

import com.market.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findFirstByNameEqualsIgnoreCase(String name);
    List<Organization> findAllByDeletedTimeIsNullOrderByIdDesc();
    List<Organization> findAllByDeletedTimeIsNotNullOrderByIdDesc();
}