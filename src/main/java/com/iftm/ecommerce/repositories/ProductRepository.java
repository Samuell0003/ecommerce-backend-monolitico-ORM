package com.iftm.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iftm.ecommerce.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(@Param("name") String name);
}
