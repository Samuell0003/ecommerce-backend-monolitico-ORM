package com.iftm.ecommerce.models;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "tb_images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private String url;

    
    public Image(Long idImage, String description, String url) {
        this.idImage = idImage;
        this.description = description;
        this.url = url;
    }

    public Image() {}

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
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
