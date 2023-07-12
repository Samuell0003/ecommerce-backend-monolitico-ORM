package com.iftm.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ecommerce.data.vo.ProductVO;
import com.iftm.ecommerce.services.ProductService;
import com.iftm.ecommerce.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
        summary = "Create a product.", description = "Create a product.", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        schema = @Schema(implementation = ProductVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public ProductVO insert(@RequestBody ProductVO product) throws Exception {
        return service.save(product);
    }

    @GetMapping(produces =  { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
        summary = "Find all.", description = "Find all products.", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Sucess.", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        array = @ArraySchema(schema = @Schema(implementation = ProductVO.class))
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        array = @ArraySchema(schema = @Schema(implementation = ProductVO.class))
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        array = @ArraySchema(schema = @Schema(implementation = ProductVO.class))
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public List<ProductVO> findAll() {
        return service.findAll();
    }
    
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
        summary = "Find by Id", description = "Product find by ID", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        schema = @Schema(implementation = ProductVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public ProductVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }
    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
        summary = "Update a product.", description = "Update a product.", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        schema = @Schema(implementation = ProductVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        schema = @Schema(implementation = ProductVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public ProductVO updateProductVO(@RequestBody ProductVO product) throws Exception {
        return service.updateProductVO(product);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "delete by Id", description = "Product delete by ID", tags = {"Product"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);
    }
    
}
