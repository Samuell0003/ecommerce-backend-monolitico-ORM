package com.iftm.ecommerce.services;

import com.iftm.ecommerce.controllers.ImageController;
import com.iftm.ecommerce.controllers.ProductController;
import com.iftm.ecommerce.data.vo.ImageVO;
import com.iftm.ecommerce.data.vo.ProductVO;
import com.iftm.ecommerce.exceptions.RequeridObjectIsNullException;
import com.iftm.ecommerce.exceptions.ResourceNotFoundException;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Image;
import com.iftm.ecommerce.models.Product;
import com.iftm.ecommerce.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageVO save(ImageVO imageVO) throws Exception {
        if (imageVO == null) throw new RequeridObjectIsNullException();
        Image image = DozerMapper.parseObject(imageVO, Image.class);
        var userDb = imageRepository.save(image);
        imageVO = DozerMapper.parseObject(userDb, ImageVO.class);
        imageVO.add(linkTo(methodOn(ProductController.class).findById(imageVO.getIdImage())).withSelfRel());

        return imageVO;
    }


    public List<ImageVO> findAll() {
        var users = DozerMapper.parseListObject(imageRepository.findAll(), ImageVO.class);

        users.stream().forEach(e -> {
            try {
                e.add(linkTo(methodOn(ProductController.class).findById(e.getIdImage())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return users;
    }


    public ImageVO findById(Long id) throws Exception {
        imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id " + id + " informado nao foi encontrado na base de dados"));

        var user = DozerMapper.parseObject(imageRepository.findById(id).get(), ImageVO.class);
        user.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());

        return user;
    }

    public ImageVO update(ImageVO imageVO) throws Exception {
        if (imageVO == null) throw new RequeridObjectIsNullException();

        var dbUser = imageRepository.findById(imageVO.getIdImage()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Image image = DozerMapper.parseObject(imageVO, Image.class);
        image = imageRepository.save(image);
        imageVO = DozerMapper.parseObject(image, ImageVO.class);
        imageVO.add(linkTo(methodOn(ImageController.class).findById(imageVO.getIdImage())).withSelfRel());
        return imageVO;
    }

    public void deleteById(Long id) throws Exception {
        imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        imageRepository.deleteById(id);
    }
}