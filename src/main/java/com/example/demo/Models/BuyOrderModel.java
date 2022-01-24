package com.example.demo.Models;

import java.util.Date;

public class BuyOrderModel {

    private Long id;
    private String price;
    private Date created_at;
    private UserModel buyer;
    private SalePostModel salePost;
    private SaleOperationModel saleOperation;

    public BuyOrderModel(){

    }

    public BuyOrderModel(Long id, String price, Date created_at, UserModel buyer, SalePostModel salePost, SaleOperationModel saleOperation) {
        this.id = id;
        this.price = price;
        this.created_at = created_at;
        this.buyer = buyer;
        this.salePost = salePost;
        this.saleOperation = saleOperation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public UserModel getBuyer() {
        return buyer;
    }

    public void setBuyer(UserModel buyer) {
        this.buyer = buyer;
    }

    public SalePostModel getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostModel salePost) {
        this.salePost = salePost;
    }

    public SaleOperationModel getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationModel saleOperation) {
        this.saleOperation = saleOperation;
    }
}
