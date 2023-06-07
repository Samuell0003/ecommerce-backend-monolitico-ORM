package com.iftm.ecommerce.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class ImageVO implements Serializable {
    private Long id_image;
    private String description;
    private String url;

    public ImageVO(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public ImageVO() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageVO imageVO = (ImageVO) o;
        return Objects.equals(id_image, imageVO.id_image) && Objects.equals(description, imageVO.description) && Objects.equals(url, imageVO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_image, description, url);
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "id_image=" + id_image +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
