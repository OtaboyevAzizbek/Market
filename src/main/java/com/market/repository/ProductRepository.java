package com.market.repository;

import com.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findFirstByNameEqualsIgnoreCase(String name);
    List<Product> findAllByOrderByIdDesc();
}