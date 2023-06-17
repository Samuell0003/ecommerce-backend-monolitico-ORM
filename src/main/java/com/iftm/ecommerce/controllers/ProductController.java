package com.iftm.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ecommerce.data.vo.ProductVO;
import com.iftm.ecommerce.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/product")
@Tag(name = "Product", description = "Endpoint for managing products.")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    @Operation(
        summary = "Create a product.", description = "Create a product.", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = ProductVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public ProductVO insert(@RequestBody ProductVO product) {
        return service.save(product);
    }




    @GetMapping
    public List<ProductVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
    
}
