package com.iftm.ecommerce.models;

import java.util.List;
import java.util.Objects;

public class Category {
    private Long idCategory;
    private String nameCategory;
    private String descrition;

    private List<Product> products;
    public Category() {
    }

    public Category(Long idCategory, String nameCategory, String descrition) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.descrition = descrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(idCategory, category.idCategory) && Objects.equals(nameCategory, category.nameCategory) && Objects.equals(descrition, category.descrition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, nameCategory, descrition);
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

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
}
