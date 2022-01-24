package com.example.demo.Models;

import java.util.List;

public class TypeModel {

    private Long id;
    private String type;
    private String image;
    private List<SalePostModel> salePosts;

    public TypeModel(){

    }

    public TypeModel(Long id, String type, String image, List<SalePostModel> salePosts) {
        this.id = id;
        this.type = type;
        this.image = image;
        this.salePosts = salePosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<SalePostModel> getSalePosts() {
        return salePosts;
    }

    public void setSalePosts(List<SalePostModel> salePosts) {
        this.salePosts = salePosts;
    }
}
