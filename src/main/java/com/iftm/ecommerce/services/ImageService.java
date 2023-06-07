package com.iftm.ecommerce.services;

import com.iftm.ecommerce.data.vo.ImageVO;
import com.iftm.ecommerce.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    
}
