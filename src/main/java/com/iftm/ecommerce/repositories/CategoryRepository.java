package com.iftm.ecommerce.repositories;

import com.iftm.ecommerce.models.Category;
import com.iftm.ecommerce.models.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
