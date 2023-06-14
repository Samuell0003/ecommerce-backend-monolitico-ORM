package com.iftm.ecommerce.models;

import java.util.List;

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
    private  double value;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "idImage")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToMany
    @JoinTable(
        name = "product_order",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;

    public Product(Long idProduct, String description, int amount, double value, Image image, Category category) {
        this.idProduct = idProduct;
        this.description = description;
        this.amount = amount;
        this.value = value;
        this.image = image;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getRequest() {
        return orders;
    }

    public void setRequest(List<Order> orders) {
        this.orders = orders;
    }
}
