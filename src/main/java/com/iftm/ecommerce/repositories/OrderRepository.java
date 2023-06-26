package com.iftm.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.ecommerce.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
