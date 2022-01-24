package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "buy_posts")
public class BuyPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;
    private boolean is_hidden;

    @ManyToOne
    @JoinColumn(name = "needy_id")
    private UserEntity needy;

    @OneToMany(mappedBy = "buyPost",cascade = CascadeType.ALL)
    private List<SalePostEntity> salePosts;

    @OneToOne(mappedBy = "buyPost")
    private SaleOperationEntity saleOperation;

    public BuyPostEntity() {
    }

    public BuyPostEntity(Long id, String content, Date created_at, boolean is_hidden, UserEntity needy, List<SalePostEntity> salePosts, SaleOperationEntity saleOperation) {
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

    public UserEntity getNeedy() {
        return needy;
    }

    public void setNeedy(UserEntity needy) {
        this.needy = needy;
    }

    public List<SalePostEntity> getSalePosts() {
        return salePosts;
    }

    public void setSalePosts(List<SalePostEntity> salePosts) {
        this.salePosts = salePosts;
    }

    public SaleOperationEntity getSaleOperation() {
        return saleOperation;
    }

    public void setSaleOperation(SaleOperationEntity saleOperation) {
        this.saleOperation = saleOperation;
    }
}
