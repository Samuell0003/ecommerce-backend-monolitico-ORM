package com.iftm.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ecommerce.services.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/product")
@Tag(name = "Product", description = "Endpoint for managing products.")
public class ProductController {
    @Autowired
    private ProductService service;

    
}
