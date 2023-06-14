package com.iftm.ecommerce.services;

import com.iftm.ecommerce.controllers.ImageController;
import com.iftm.ecommerce.controllers.exceptions.RequiredObjectIsNullException;
import com.iftm.ecommerce.controllers.exceptions.ResourceNotFoundException;
import com.iftm.ecommerce.data.vo.ImageVO;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Image;
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

    public List<ImageVO> findAll() {
        var imageDbList = imageRepository.findAll();
        var images = DozerMapper.parseListObject(imageDbList, ImageVO.class);
        images.stream().forEach(image -> {
            try {
                image.add(linkTo(methodOn(ImageController.class).findById(image.getId_image()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return images;
    }

    public ImageVO findById(Long id) throws Exception {
        var userDb = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var user = DozerMapper.parseObject(userDb, ImageVO.class);
        user.add(linkTo(methodOn(ImageController.class).findById(id)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return user;
    }

    public List<ImageVO> findByGroupName(String groupName) {
        List<Image> images = imageRepository.findUsersByGroupName(groupName);
        var usersVO = DozerMapper.parseListObject(images, ImageVO.class);
        usersVO.stream().forEach(images -> {
            try {
                images.add(linkTo(methodOn(ImageController.class).findById(images.getId_image()))
                        .withSelfRel()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return usersVO;
    }

    public ImageVO save(ImageVO imageVO) throws Exception{
        if(imageVO == null) throw new RequiredObjectIsNullException();

        Image image = DozerMapper.parseObject(imageVO, Image.class);
        var imageDb = imageRepository.save(image);
        imageVO = DozerMapper.parseObject(imageDb, ImageVO.class);
        imageVO.add(linkTo(methodOn(ImageController.class).findById(imageVO.getId_image())).withSelfRel());
        return imageVO;
    }

    public ImageVO update(ImageVO imageVO) throws Exception {
        if(imageVO == null) throw new RequiredObjectIsNullException();

        var dbImage = imageRepository.findById(ImageVO.getId_image()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Image image = DozerMapper.parseObject(ImageVO, Image.class);
        image = imageRepository.save(image);
        imageVO = DozerMapper.parseObject(image, ImageVO.class);
        imageVO.add(linkTo(methodOn(ImageController.class).findById(imageVO.getId_image())).withSelfRel());
        return imageVO;
    }

    public String delete(Long id) {
        var dbImage = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        imageRepository.deleteById(id);
        return "User with id " + id + " has been deleted!";
    }
    
}
