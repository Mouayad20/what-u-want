package com.example.demo.Models;

import java.util.Date;
import java.util.List;

public class EmployeeModel {

    private Long id;
    private String name;
    private String password;
    private String mobile;
    private String image;
    private String region;
    private Date created_at;
    private int rate;
    private boolean is_free;
    private List<DeliveryOperationModel> deliveryOperations  ;

    public EmployeeModel(){

    }

    public EmployeeModel(Long id, String name, String password, String mobile, String image, String region, int rate, boolean is_free, List<DeliveryOperationModel> deliveryOperations) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.image = image;
        this.region = region;
        this.rate = rate;
        this.is_free = is_free;
        this.deliveryOperations = deliveryOperations;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public List<DeliveryOperationModel> getDeliveryOperations() {
        return deliveryOperations;
    }

    public void setDeliveryOperations(List<DeliveryOperationModel> deliveryOperations) {
        this.deliveryOperations = deliveryOperations;
    }
}
