package com.example.demo.Models;

import java.util.Date;
import java.util.List;

public class SaleOperationModel {

    private Long id;
    private Date created_at;
    private boolean is_done;
    private SalePostModel salePost;
    private BuyPostModel buyPost;
    private BuyOrderModel buyOrder;
    private List<DeliveryOperationModel> deliveryOperations ;

    public SaleOperationModel() {
    }

    public SaleOperationModel(Long id, Date created_at, boolean is_done, SalePostModel salePost, BuyPostModel buyPost, BuyOrderModel buyOrder, List<DeliveryOperationModel> deliveryOperations) {
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

    public SalePostModel getSalePost() {
        return salePost;
    }

    public void setSalePost(SalePostModel salePost) {
        this.salePost = salePost;
    }

    public BuyPostModel getBuyPost() {
        return buyPost;
    }

    public void setBuyPost(BuyPostModel buyPost) {
        this.buyPost = buyPost;
    }

    public BuyOrderModel getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(BuyOrderModel buyOrder) {
        this.buyOrder = buyOrder;
    }

    public List<DeliveryOperationModel> getDeliveryOperations() {
        return deliveryOperations;
    }

    public void setDeliveryOperations(List<DeliveryOperationModel> deliveryOperations) {
        this.deliveryOperations = deliveryOperations;
    }
}
