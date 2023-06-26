package com.iftm.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.ecommerce.controllers.OrderController;
import com.iftm.ecommerce.data.vo.OrderVO;
import com.iftm.ecommerce.exceptions.RequeridObjectIsNullException;
import com.iftm.ecommerce.exceptions.ResourceNotFoundException;
import com.iftm.ecommerce.mapper.DozerMapper;
import com.iftm.ecommerce.models.Order;
import com.iftm.ecommerce.repositories.OrderRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository repository;

    public OrderVO save(OrderVO orderVO) throws Exception {
        if (orderVO == null) new RequeridObjectIsNullException();

        var order = DozerMapper.parseObject(orderVO, Order.class);
        var orderdb = repository.save(order);
        orderVO = DozerMapper.parseObject(orderdb, OrderVO.class);
        orderVO.add(linkTo(methodOn(OrderController.class).findByid(orderdb.getIdOrder())).withSelfRel());

        return orderVO;

    }

    public List<OrderVO> findAll() {
        var orders = DozerMapper.parseListObject(repository.findAll(), OrderVO.class);

        orders.stream().forEach(order -> {
            try {
                order.add(linkTo(methodOn(OrderController.class).findByid(order.getIdOrder())).withSelfRel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        return orders;
    }

    public OrderVO findById(Long id) throws Exception {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id "+id+" informado nao foi encontrado na base de dados"));

        var order = DozerMapper.parseObject(repository.findById(id).get(), OrderVO.class);
        order.add(linkTo(methodOn(OrderController.class).findByid(id)).withSelfRel());
        return order;
    }


    public void deleteById(Long id) throws Exception {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
    }
}
