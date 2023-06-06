package com.iftm.ecommerce.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/image")
@Tag(name = "Image", description = "Endpoint for managing Images.")
public class ImageController {

}
