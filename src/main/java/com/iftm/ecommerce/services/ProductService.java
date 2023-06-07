package com.iftm.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.ecommerce.repositories.ProductRepository;
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    
}
