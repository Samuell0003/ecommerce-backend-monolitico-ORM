package com.iftm.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.ecommerce.controllers.ProductController;
import com.iftm.ecommerce.data.vo.ImageVO;
import com.iftm.ecommerce.data.vo.ProductVO;
import com.iftm.ecommerce.exceptions.RequeridObjectIsNullException;
import com.iftm.ecommerce.exceptions.ResourceNotFoundException;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Image;
import com.iftm.ecommerce.models.Product;
import com.iftm.ecommerce.repositories.ProductRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ImageService imageService;
    public ProductVO save(ProductVO productVO) throws Exception {
        if (productVO == null) throw new RequeridObjectIsNullException();

        try {
            repository.findById(productVO.getIdProduct());
        } catch (Exception e) {
            var imgDB = imageService.save(DozerMapper.parseObject(productVO.getImage(), ImageVO.class));
            productVO.setImage(DozerMapper.parseObject(imgDB, Image.class));        
        }
        
        Product product = DozerMapper.parseObject(productVO, Product.class);
        var userDb = repository.save(product);
        productVO = DozerMapper.parseObject(userDb, ProductVO.class);
        productVO.add(linkTo(methodOn(ProductController.class).findById(productVO.getIdProduct())).withSelfRel());

        return productVO;
    }


    public List<ProductVO> findAll() {
        var users = DozerMapper.parseListObject(repository.findAll(), ProductVO.class);

        users.stream().forEach(e -> {
            try {
                e.add(linkTo(methodOn(ProductController.class).findById(e.getIdProduct())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return users;
    }

         

    public ProductVO findById(Long id) throws Exception {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id "+id+" informado nao foi encontrado na base de dados"));
        
        var user = DozerMapper.parseObject(repository.findById(id).get(),  ProductVO.class);
        user.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());

        return user;
    }

    public void deleteById(Long id) throws Exception {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
    }

    public ProductVO updateProductVO(ProductVO productVO) throws Exception {
        if (productVO == null) throw new RequeridObjectIsNullException();

        repository.findById(productVO.getIdProduct()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
       
        Product product = DozerMapper.parseObject(productVO, Product.class);
        var productDb = repository.save(product);
        productVO = DozerMapper.parseObject(productDb, ProductVO.class);
        productVO.add(linkTo(methodOn(ProductController.class).findById(productVO.getIdProduct())).withSelfRel());

        return productVO;
    }
}
