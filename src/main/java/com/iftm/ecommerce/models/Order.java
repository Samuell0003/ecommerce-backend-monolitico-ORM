package com.iftm.ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    @Column
    private String description;

    @ManyToMany
    @JoinTable(
        name = "product_order",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Product> products;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDateTime dateOrder;
    @Column
    private Double fullValue = 0D;


    public Order (String description, List<Product> products, LocalDateTime dateOrder) {
        this.description = description;
        this.products = products;
        this.dateOrder = dateOrder;
    }

    public Order() {}

    @PreUpdate
    public void fullValueget() {
        for (Product product: products) {
            this.fullValue += product.getValue();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(idOrder, order.idOrder) && Objects.equals(products, order.products) && Objects.equals(dateOrder, order.dateOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, products, dateOrder);
    }

    public Double getfullValue() {
        for (Product product: products) {
            this.fullValue += product.getValue();
        }

        return fullValue;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
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

   
}
