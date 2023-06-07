package com.iftm.ecommerce.models;

import java.util.List;
import java.util.Objects;

public class Product {

    private Long idProduct;
    private String description;
    private int amount;
    private  double value;
    private Image image;
    private Category category;

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
