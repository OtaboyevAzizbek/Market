package com.market.repository;

import com.market.entity.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {
    UnitType findFirstByNameEqualsIgnoreCase(String name);

    List<UnitType> findAllByOrderByIdDesc();
}