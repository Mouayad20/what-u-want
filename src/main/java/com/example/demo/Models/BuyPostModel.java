package com.example.demo.Models;

import java.util.Date;
import java.util.List;

public class BuyPostModel {

    private Long id;
    private String content ;
    private Date created_at;
    private boolean is_hidden;
    private UserModel needy;
    private List<SalePostModel> salePosts;
    private SaleOperationModel saleOperation;

    public BuyPostModel(){

    }

    public BuyPostModel(Long id, String content, Date created_at, boolean is_hidden, UserModel needy, List<SalePostModel> salePosts, SaleOperationModel saleOperation) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.is_hidden = is_hidden;
        this.needy = needy;
        this.salePosts = salePosts;
        this.saleOperation = saleOperation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public UserModel getNeedy() {
        return needy;
    }

    public void setNeedy(UserModel needy) {
        this.needy = needy;
    }

    public List<SalePostModel> getSalePosts() {
        return salePosts;
    }

    public void setSalePosts(List<SalePostModel> salePosts) {
        this.salePosts = salePosts;
    }

    public SaleOperationModel getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationModel saleOperation) {
        this.saleOperation = saleOperation;
    }
}
