package com.iftm.ecommerce.services;

import com.iftm.ecommerce.controllers.CategoryController;
import com.iftm.ecommerce.data.vo.CategoryVO;
import com.iftm.ecommerce.exceptions.RequeridObjectIsNullException;
import com.iftm.ecommerce.exceptions.RequiredFieldNotInformed;
import com.iftm.ecommerce.exceptions.ResourceNotFoundException;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Category;
import com.iftm.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryVO save(CategoryVO categoryVO) throws Exception {
        if (categoryVO == null) throw new RequeridObjectIsNullException();
        if (categoryVO.getNameCategory().isEmpty() || categoryVO.getNameCategory().isBlank())  
            throw new RequiredFieldNotInformed();
            
        Category category = DozerMapper.parseObject(categoryVO, Category.class);
        var userDb = categoryRepository.save(category);
        categoryVO = DozerMapper.parseObject(userDb, CategoryVO.class);
        categoryVO.add(linkTo(methodOn(CategoryController.class).findById(categoryVO.getIdCategory())).withSelfRel());

        return categoryVO;
    }


    public List<CategoryVO> findAll() {
        var users = DozerMapper.parseListObject(categoryRepository.findAll(), CategoryVO.class);

        users.stream().forEach(e -> {
            try {
                e.add(linkTo(methodOn(CategoryController.class).findById(e.getIdCategory())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return users;
    }


    public CategoryVO findById(Long id) throws Exception {
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id " + id + " informado nao foi encontrado na base de dados"));

        var user = DozerMapper.parseObject(categoryRepository.findById(id).get(), CategoryVO.class);
        user.add(linkTo(methodOn(CategoryController.class).findById(id)).withSelfRel());

        return user;
    }

    public CategoryVO update(CategoryVO categoryVO) throws Exception {
        if (categoryVO == null) throw new RequeridObjectIsNullException();

        categoryRepository.findById(categoryVO.getIdCategory()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Category category = DozerMapper.parseObject(categoryVO, Category.class);
        category = categoryRepository.save(category);
        categoryVO = DozerMapper.parseObject(category, CategoryVO.class);
        categoryVO.add(linkTo(methodOn(CategoryController.class).findById(categoryVO.getIdCategory())).withSelfRel());
        return categoryVO;
    }

    public void deleteById(Long id) throws Exception {
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        categoryRepository.deleteById(id);
    }
}
