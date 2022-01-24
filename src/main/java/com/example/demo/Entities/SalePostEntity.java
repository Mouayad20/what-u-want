package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "sale_posts")
public class SalePostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post_type;
    private String post_status;
    private String item_name;
    private String item_price;
    private String item_status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;
    private boolean is_hidden;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "buy_post_id")
    private BuyPostEntity buyPost;

    @OneToMany(mappedBy = "salePost" , cascade = CascadeType.ALL)
    private List<BuyOrderEntity> buyOrders ;

    @OneToMany(mappedBy = "salePost" , cascade = CascadeType.ALL)
    private List<ImageEntity> images  ;

    @OneToOne(mappedBy = "salePost")
    private SaleOperationEntity saleOperation;

    @ManyToOne
    @JoinColumn(name = "item_type")
    private TypeEntity item_type;


    public SalePostEntity(){

        this.images = new ArrayList<>();

    }

    public SalePostEntity(Long id, String post_type, String post_status, String item_name, String item_price, TypeEntity item_type, String item_status, Date created_at, boolean is_hidden, UserEntity seller, BuyPostEntity buyPost, List<BuyOrderEntity> buyOrders, List<ImageEntity> images, SaleOperationEntity saleOperation) {
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

    public TypeEntity getItem_type() {
        return item_type;
    }

    public void setItem_type(TypeEntity item_type) {
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

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public BuyPostEntity getBuyPost() {
        return buyPost;
    }

    public void setBuyPost(BuyPostEntity buyPost) {
        this.buyPost = buyPost;
    }

    public List<BuyOrderEntity> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<BuyOrderEntity> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public SaleOperationEntity getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationEntity saleOperation) {
        this.saleOperation = saleOperation;
    }
}
