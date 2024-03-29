package com.iftm.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.ecommerce.models.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
