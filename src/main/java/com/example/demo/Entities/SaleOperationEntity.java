package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "sale_operations")
public class SaleOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;
    private boolean is_done;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_post_id",referencedColumnName = "id")
    private SalePostEntity salePost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buy_post_id",referencedColumnName = "id")
    private BuyPostEntity buyPost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buy_order_id",referencedColumnName = "id")
    private BuyOrderEntity buyOrder;

    @OneToMany(mappedBy = "saleOperation" , cascade = CascadeType.ALL)
    private List<DeliveryOperationEntity> deliveryOperations ;

    public SaleOperationEntity(){
    }

    public SaleOperationEntity(Long id, Date created_at, boolean is_done, SalePostEntity salePost, BuyPostEntity buyPost, BuyOrderEntity buyOrder, List<DeliveryOperationEntity> deliveryOperations) {
        this.id = id;
        this.created_at = created_at;
        this.is_done = is_done;
        this.salePost = salePost;
        this.buyPost = buyPost;
        this.buyOrder = buyOrder;
        this.deliveryOperations = deliveryOperations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public SalePostEntity getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostEntity salePost) {
        this.salePost = salePost;
    }

    public BuyPostEntity getBuyPost() {
        return buyPost;
    }

    public void setBuyPost(BuyPostEntity buyPost) {
        this.buyPost = buyPost;
    }

    public BuyOrderEntity getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(BuyOrderEntity buyOrder) {
        this.buyOrder = buyOrder;
    }

    public List<DeliveryOperationEntity> getDeliveryOperations() {
        return deliveryOperations;
    }

    public void setDeliveryOperations(List<DeliveryOperationEntity> deliveryOperations) {
        this.deliveryOperations = deliveryOperations;
    }
}
