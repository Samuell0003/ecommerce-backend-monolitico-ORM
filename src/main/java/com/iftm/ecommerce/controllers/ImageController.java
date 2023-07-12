package com.iftm.ecommerce.controllers;

import com.iftm.ecommerce.data.vo.ImageVO;
import com.iftm.ecommerce.services.ImageService;
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
@RequestMapping("api/v1/image")
@Tag(name = "Image", description = "Endpoint for managing Images.")
public class ImageController {
    @Autowired
    private ImageService imageService;
    
    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find all image.", description = "Find all images.", tags = {"Image"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                        content = {
                                @Content(mediaType = MediaType.APPLICATION_JSON,
                                        array = @ArraySchema(schema = @Schema(implementation = ImageVO.class))
                                ),
                                @Content(mediaType = MediaType.APPLICATION_XML,
                                        array = @ArraySchema(schema = @Schema(implementation = ImageVO.class))
                                ),
                                @Content(mediaType = MediaType.APPLICATION_YML,
                                        array = @ArraySchema(schema = @Schema(implementation = ImageVO.class))
                                )
                        }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public List<ImageVO> findAll() {
        return imageService.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Find a image by ID.", description = "Find a image by ID.", tags = {"Image"},
            responses = { 
                @ApiResponse(description = "Success", responseCode = "200",
                        content = {
                                @Content(mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = ImageVO.class)
                                )
                        }),
                @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
                }       
    )
    public ImageVO findById(@PathVariable("id") Long id) throws Exception {
        return imageService.findById(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Create a image.", description = "Create a image.", tags = {"Image"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = ImageVO.class)
                                )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ImageVO save(@RequestBody ImageVO imageVO) throws Exception {
        return imageService.save(imageVO);
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Update a image.", description = "Update a image.", tags = {"Image"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_XML,
                                        schema = @Schema(implementation = ImageVO.class)
                                ),
                                @Content(
                                        mediaType = MediaType.APPLICATION_YML,
                                        schema = @Schema(implementation = ImageVO.class)
                                )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ImageVO update(@RequestBody ImageVO imageVO) throws Exception {
        return imageService.update(imageVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Image by ID.", description = "Deletes a Image by ID.", tags = {"Image"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public void delete(@PathVariable("id") Long id) throws Exception {
        imageService.deleteById(id);
    }
}
