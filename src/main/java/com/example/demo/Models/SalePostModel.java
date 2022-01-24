package com.example.demo.Models;

import java.util.Date;
import java.util.List;

public class SalePostModel {

    private Long    id;
    private String  post_type;
    private String  post_status;
    private String  item_name;
    private String  item_price;
    private TypeModel  item_type;
    private String  item_status;
    private Date    created_at;
    private boolean is_hidden;
    private UserModel    seller;
    private BuyPostModel buyPost;
    private List<BuyOrderModel> buyOrders ;
    private List<ImageModel>    images  ;
    private SaleOperationModel  saleOperation;

    public SalePostModel(){
    }

    public SalePostModel(Long id, String post_type, String post_status, String item_name, String item_price, TypeModel item_type, String item_status, Date created_at, boolean is_hidden, UserModel seller, BuyPostModel buyPost, List<BuyOrderModel> buyOrders, List<ImageModel> images, SaleOperationModel saleOperation) {
        this.id = id;
        this.post_type = post_type;
        this.post_status = post_status;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_type = item_type;
        this.item_status = item_status;
        this.created_at = created_at;
        this.is_hidden = is_hidden;
        this.seller = seller;
        this.buyPost = buyPost;
        this.buyOrders = buyOrders;
        this.images = images;
        this.saleOperation = saleOperation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getPost_status() {
        return post_status;
    }

    public void setPost_status(String post_status) {
        this.post_status = post_status;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public TypeModel getItem_type() {
        return item_type;
    }

    public void setItem_type(TypeModel item_type) {
        this.item_type = item_type;
    }

    public String getItem_status() {
        return item_status;
    }

    public void setItem_status(String item_status) {
        this.item_status = item_status;
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

    public UserModel getSeller() {
        return seller;
    }

    public void setSeller(UserModel seller) {
        this.seller = seller;
    }

    public BuyPostModel getBuyPost() {
        return buyPost;
    }

    public void setBuyPost(BuyPostModel buyPost) {
        this.buyPost = buyPost;
    }

    public List<BuyOrderModel> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<BuyOrderModel> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public SaleOperationModel getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationModel saleOperation) {
        this.saleOperation = saleOperation;
    }
}

