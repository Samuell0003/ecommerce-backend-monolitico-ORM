package com.iftm.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ecommerce.data.vo.OrderVO;
import com.iftm.ecommerce.services.OrderServices;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/order")
@Tag(name = "Order", description = "Endpoint for managing order.")
public class OrderController {

    @Autowired
    private OrderServices service;

    @PostMapping
    public OrderVO save(@RequestBody OrderVO order) throws Exception {
        return save(order);
    }

    @GetMapping(value = "/{id}")
    public OrderVO findByid(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping
    public List<OrderVO> findAll() {
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);
    }
}
