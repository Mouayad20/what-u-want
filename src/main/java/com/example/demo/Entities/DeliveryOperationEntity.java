package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "delivery_operations")
public class DeliveryOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  operation_type;
    private String  reason;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    created_at;
    private int     rate;
    private boolean is_done;

    @ManyToOne
    @JoinColumn(name = "sale_operation_id")
    private SaleOperationEntity saleOperation;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee ;

    public DeliveryOperationEntity(){}

    public DeliveryOperationEntity(Long id, String operation_type, String reason, Date created_at, int rate, boolean is_done, SaleOperationEntity saleOperation, EmployeeEntity employee) {
        this.id = id;
        this.operation_type = operation_type;
        this.reason = reason;
        this.created_at = created_at;
        this.rate = rate;
        this.is_done = is_done;
        this.saleOperation = saleOperation;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public SaleOperationEntity getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationEntity saleOperation) {
        this.saleOperation = saleOperation;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
