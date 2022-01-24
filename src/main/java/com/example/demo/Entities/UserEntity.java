package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String location;
    private String mobile;
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date   created_at;
    private int    rate;
    private int    num_reports;

    @OneToMany(mappedBy = "seller" , cascade = CascadeType.ALL)
    private List<SalePostEntity> salePosts ;

    @OneToMany(mappedBy = "buyer" , cascade = CascadeType.ALL)
    private List<BuyOrderEntity> buyOrders ;

    @OneToMany(mappedBy = "needy" , cascade = CascadeType.ALL)
    private List<BuyPostEntity>  buyPosts ;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String password, String location, String mobile, String image, Date created_at, int rate, int num_reports, List<SalePostEntity> salePosts, List<BuyOrderEntity> buyOrders, List<BuyPostEntity> buyPosts) {
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

    public List<SalePostEntity> getSalePosts() {
        return salePosts;
    }

    public void setSalePosts(List<SalePostEntity> salePosts) {
        this.salePosts = salePosts;
    }

    public List<BuyOrderEntity> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<BuyOrderEntity> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<BuyPostEntity> getBuyPosts() {
        return buyPosts;
    }

    public void setBuyPosts(List<BuyPostEntity> buyPosts) {
        this.buyPosts = buyPosts;
    }


}
