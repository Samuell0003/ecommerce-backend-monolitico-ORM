package com.iftm.ecommerce.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(name = "name_category",nullable = false)
    private String nameCategory;

    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", targetEntity = Product.class)
    private List<Product> products;

    public Category() {
    }

    public Category(Long idCategory, String nameCategory, String description) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(idCategory, category.idCategory) && Objects.equals(nameCategory, category.nameCategory) && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, nameCategory, description);
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
