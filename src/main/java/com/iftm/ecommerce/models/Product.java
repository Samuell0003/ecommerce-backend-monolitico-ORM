package com.iftm.ecommerce.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProduct;
    @Column(name = "description", nullable = false, length = 120)
    private String description;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "value", nullable = false)
    private  double value;
    @OneToOne
    private Image image;
    @ManyToOne
    @JsonIgnore
    private Category category;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_order",
              joinColumns = {@JoinColumn(name = "product_id")},
              inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> request;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount && Double.compare(product.value, value) == 0 && Objects.equals(idProduct, product.idProduct) && Objects.equals(description, product.description) && Objects.equals(image, product.image) && Objects.equals(category, product.category) && Objects.equals(request, product.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, description, amount, value, image, category, request);
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

    public List<Order> getRequest() {
        return request;
    }

    public void setRequest(List<Order> request) {
        this.request = request;
    }
}
