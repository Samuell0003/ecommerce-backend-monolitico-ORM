package com.iftm.ecommerce.data.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iftm.ecommerce.models.Category;
import com.iftm.ecommerce.models.Image;
import com.iftm.ecommerce.models.Order;

public class ProductVO extends RepresentationModel<ProductVO> implements Serializable {
    private Long idProduct;

    private String name;

    private String description;

    private int amount;

    private  double value;

    private Image image;

    private Category category;
    
    @JsonIgnore
    private List<Order> orders;

    public ProductVO(String description, int amount, double value, Image image, Category category,
            List<Order> orders, String name) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.value = value;
        this.image = image;
        this.category = category;
        this.orders = orders;
    }

    public ProductVO() {

    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
