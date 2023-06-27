package com.iftm.ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


import jakarta.persistence.*;
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime dateOrder;

    public Order(Long idOrder, List<Product> products, LocalDateTime dateOrder) {
        this.idOrder = idOrder;
        this.products = products;
        this.dateOrder = dateOrder;
    }

    public Order() {}

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

    public double fullValue() {
        double valueFull = 0;
        for (Product product: products) {
            valueFull += product.getValue();
        }

        return valueFull;
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
}
