package com.example.demo.Entities;

import javax.persistence.*;

@Entity(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String path;

    @ManyToOne
    @JoinColumn(name = "sale_post_id")
    private SalePostEntity salePost;

    public ImageEntity() {

    }

    public ImageEntity(Long id, String path, SalePostEntity salePost) {
        if (id != null) this.id = id;
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

    public SalePostEntity getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostEntity salePost) {
        this.salePost = salePost;
    }
}
