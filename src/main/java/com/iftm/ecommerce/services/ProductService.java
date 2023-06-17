package com.iftm.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.ecommerce.data.vo.ProductVO;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Product;
import com.iftm.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductVO save(ProductVO productVO) {
        Product product = DozerMapper.parseObject(productVO, Product.class);
        var userDb = repository.save(product);
        productVO = DozerMapper.parseObject(userDb, ProductVO.class);

        return productVO;
    }


    public List<ProductVO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), ProductVO.class);
    }

    public ProductVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).get(),  ProductVO.class);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
