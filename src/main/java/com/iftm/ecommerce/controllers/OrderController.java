package com.iftm.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ecommerce.data.vo.OrderVO;
import com.iftm.ecommerce.services.OrderServices;
import com.iftm.ecommerce.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/order")
@Tag(name = "Order", description = "Endpoint for managing order.")
public class OrderController {

    @Autowired
    private OrderServices service;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
        summary = "Create a order.", description = "Create a order.", tags = {"Order"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = OrderVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        schema = @Schema(implementation = OrderVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        schema = @Schema(implementation = OrderVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public OrderVO save(@RequestBody OrderVO order) throws Exception {
        return service.save(order);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find a order by ID.", description = "Find a order by ID.", tags = {"Order"},
            responses = { 
                @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                        @Content(mediaType = MediaType.APPLICATION_JSON,
                                schema = @Schema(implementation = OrderVO.class)
                        ),
                        @Content(mediaType = MediaType.APPLICATION_XML,
                                schema = @Schema(implementation = OrderVO.class)
                        ),
                        @Content(mediaType = MediaType.APPLICATION_YML,
                                schema = @Schema(implementation = OrderVO.class)
                        )
                    }),
                @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }       
    )
    public OrderVO findByid(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
        summary = "Find all order.", description = "Find all orders.", tags = {"Order"},
        responses = {
            @ApiResponse(description = "Sucess.", responseCode = "200",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON,
                            array = @ArraySchema(schema = @Schema(implementation = OrderVO.class))
                    ),
                    @Content(mediaType = MediaType.APPLICATION_XML,
                            array = @ArraySchema(schema = @Schema(implementation = OrderVO.class))
                    ),
                    @Content(mediaType = MediaType.APPLICATION_YML,
                            array = @ArraySchema(schema = @Schema(implementation = OrderVO.class))
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<OrderVO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Order by ID.", description = "Deletes a Order by ID.", tags = {"Order"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
        summary = "Update a order.", description = "Update a order.", tags = {"Order"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = OrderVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_XML,
                        schema = @Schema(implementation = OrderVO.class)
                    ),
                    @Content(
                        mediaType = MediaType.APPLICATION_YML,
                        schema = @Schema(implementation = OrderVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public OrderVO update(@RequestBody OrderVO orderVO) throws Exception {
        return service.update(orderVO);
    }


    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }
}
