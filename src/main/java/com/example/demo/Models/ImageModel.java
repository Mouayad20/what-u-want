package com.example.demo.Models;

import com.example.demo.Entities.SalePostEntity;

public class ImageModel {

    private long id;
    private String path;
    private SalePostModel salePost;

    public ImageModel() {

    }

    public ImageModel(long id, String path, SalePostModel salePost) {
        this.id = id;
        this.path = path;
        this.salePost = salePost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SalePostModel getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostModel salePost) {
        this.salePost = salePost;
    }


}
