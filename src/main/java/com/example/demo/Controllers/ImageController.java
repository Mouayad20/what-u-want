package com.example.demo.Controllers;

import com.example.demo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/image")
public class ImageController {

    @Autowired
    ImageService imageService;
}
