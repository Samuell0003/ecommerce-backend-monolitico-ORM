package com.iftm.ecommerce.data.vo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class ImageVO extends RepresentationModel<ImageVO> implements Serializable {
    private Long idImage;
    private String description;
    private String url;

    public ImageVO(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public ImageVO() {
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
        return Objects.equals(idImage, imageVO.idImage) && Objects.equals(description, imageVO.description) && Objects.equals(url, imageVO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImage, description, url);
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "idImage=" + idImage +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

//    public void add(Link withSelfRel) {
//    }
}
