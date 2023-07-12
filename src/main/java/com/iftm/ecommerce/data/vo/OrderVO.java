package com.iftm.ecommerce.data.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.iftm.ecommerce.models.Product;


public class OrderVO extends RepresentationModel<OrderVO> implements Serializable {

    private Long idOrder;
    private String description;
    private List<Product> products;
    private LocalDateTime dateOrder =  LocalDateTime.now();
    private Double fullValue = 0D;
    


    public OrderVO(String description, List<Product> products, LocalDateTime dateOrder) {
        this.description = description;
        this.products = products;
        this.dateOrder = dateOrder;
    }

    public OrderVO() { }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Double getFullValue() {
        return fullValue;
    }

    public void setFullValue(Double fullValue) {
        this.fullValue = fullValue;
    }

}
