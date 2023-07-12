package com.iftm.ecommerce.controllers;

import com.iftm.ecommerce.data.vo.CategoryVO;
import com.iftm.ecommerce.services.CategoryService;
import com.iftm.ecommerce.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/category")
@Tag(name = "Category", description = "Endpoint for managing categorys.")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML })
    @Operation(
            summary = "Find all categorys.", description = "Find all categorys.", tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON,
                                                array = @ArraySchema(schema = @Schema(implementation = CategoryVO.class))
                                        ),
                                        @Content(mediaType = MediaType.APPLICATION_XML,
                                                array = @ArraySchema(schema = @Schema(implementation = CategoryVO.class))
                                        ),
                                        @Content(mediaType = MediaType.APPLICATION_YML,
                                                array = @ArraySchema(schema = @Schema(implementation = CategoryVO.class))
                                        )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public List<CategoryVO> findAll() {
        return categoryService.findAll();
    }

  
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find a category by ID.", description = "Find a category by ID.", tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = CategoryVO.class)
                                    ),
                                    @Content(mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                    ),
                                    @Content(mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public CategoryVO findById(@PathVariable("id") Long id) throws Exception {
        return categoryService.findById(id);
    }
        

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Create a category.", description = "Create a category.", tags = {"Category"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = CategoryVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public CategoryVO save(@RequestBody CategoryVO categoryVO) throws Exception {
        return categoryService.save(categoryVO);
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Update a category.", description = "Update a category.", tags = {"Category"},
            responses = {
                   @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = CategoryVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = CategoryVO.class)
                                )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public CategoryVO update(@RequestBody CategoryVO categoryVO) throws Exception {
        return categoryService.update(categoryVO);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Category by ID.", description = "Deletes a Category by ID.", tags = {"Category"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public void delete(@PathVariable("id") Long id) throws Exception {
        categoryService.deleteById(id);
    }
}
