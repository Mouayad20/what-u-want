package com.example.demo.Models;

import java.util.Date;
import java.util.List;

public class UserModel {

    private Long id;
    private String name;
    private String password;
    private String location;
    private String mobile;
    private String image;
    private Date   created_at;
    private int    rate;
    private int    num_reports;
    private List<SalePostModel>  salePosts ;
    private List<BuyOrderModel>  buyOrders ;
    private List<BuyPostModel>  buyPosts ;


    public UserModel(){

    }

    public UserModel(Long id, String name, String password, String location, String mobile, String image, Date created_at, int rate, int num_reports, List<SalePostModel> salePosts, List<BuyOrderModel> buyOrders, List<BuyPostModel> buyPosts) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.location = location;
        this.mobile = mobile;
        this.image = image;
        this.created_at = created_at;
        this.rate = rate;
        this.num_reports = num_reports;
        this.salePosts = salePosts;
        this.buyOrders = buyOrders;
        this.buyPosts = buyPosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNum_reports() {
        return num_reports;
    }

    public void setNum_reports(int num_reports) {
        this.num_reports = num_reports;
    }

    public List<SalePostModel> getSalePosts() {
        return salePosts;
    }

    public void setSalePosts(List<SalePostModel> salePosts) {
        this.salePosts = salePosts;
    }

    public List<BuyOrderModel> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<BuyOrderModel> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<BuyPostModel> getBuyPosts() {
        return buyPosts;
    }

    public void setBuyPosts(List<BuyPostModel> buyPosts) {
        this.buyPosts = buyPosts;
    }
}
