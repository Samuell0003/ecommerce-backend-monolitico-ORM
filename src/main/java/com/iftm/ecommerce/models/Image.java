package com.iftm.ecommerce.models;

import java.util.Objects;

public class Image {
    private Long id_image;
    private String descrition;
    private String url;

    public Image(Long id_image, String descrition, String url) {
        this.id_image = id_image;
        this.descrition = descrition;
        this.url = url;
    }

    public Image() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id_image, image.id_image) && Objects.equals(descrition, image.descrition) && Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_image, descrition, url);
    }

    public Long getId_image() {
        return id_image;
    }

    public void setId_image(Long id_image) {
        this.id_image = id_image;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
