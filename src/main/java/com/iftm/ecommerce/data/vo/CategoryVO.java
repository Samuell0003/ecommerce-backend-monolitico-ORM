package com.iftm.ecommerce.data.vo;

import com.iftm.ecommerce.models.Category;
import com.iftm.ecommerce.models.Product;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CategoryVO extends RepresentationModel<CategoryVO> implements Serializable {
    private Long idCategory;

    private String nameCategory;

    private String description;

    private List<Product> products;

    public CategoryVO() {
    }

    public CategoryVO(Long idCategory, String nameCategory, String description) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryVO categoryvo = (CategoryVO) o;
        return Objects.equals(idCategory, categoryvo.idCategory) && Objects.equals(nameCategory, categoryvo.nameCategory) && Objects.equals(description, categoryvo.description);
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
