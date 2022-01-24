package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "buy_orders")
public class BuyOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserEntity buyer;

    @ManyToOne
    @JoinColumn(name = "sale_post_id")
    private SalePostEntity salePost;

    @OneToOne(mappedBy = "buyOrder")
    private SaleOperationEntity saleOperation;

    public BuyOrderEntity() {
    }

    public BuyOrderEntity(Long id, String price, Date created_at, UserEntity buyer, SalePostEntity salePost, SaleOperationEntity saleOperation) {
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

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    public SalePostEntity getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostEntity salePost) {
        this.salePost = salePost;
    }

    public SaleOperationEntity getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationEntity saleOperation) {
        this.saleOperation = saleOperation;
    }
}
