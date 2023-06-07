package com.iftm.ecommerce.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_image;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false)
    private String url;

    public Image(Long id_image, String description, String url) {
        this.id_image = id_image;
        this.description = description;
        this.url = url;
    }

    public Image() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id_image, image.id_image) && Objects.equals(description, image.description) && Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_image, description, url);
    }

    public Long getId_image() {
        return id_image;
    }

    public void setId_image(Long id_image) {
        this.id_image = id_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
