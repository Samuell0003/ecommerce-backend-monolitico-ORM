package com.iftm.ecommerce.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "description", nullable = false, length = 120)
    private String description;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "value", nullable = false)
    private double value;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "idImage", nullable = false)
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;

    public Product(Long idProduct, String description, int amount, double value, Image image, Category category,
            List<Order> orders) {
        this.idProduct = idProduct;
        this.description = description;
        this.amount = amount;
        this.value = value;
        this.image = image;
        this.category = category;
        this.orders = orders;
    }

    public Product() {

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
}
