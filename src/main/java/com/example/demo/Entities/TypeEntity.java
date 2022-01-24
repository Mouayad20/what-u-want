package com.example.demo.Entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String image;

    @OneToMany(mappedBy = "item_type" , cascade = CascadeType.ALL)
    private List<SalePostEntity> postEntities;

    public TypeEntity(){

    }

    public TypeEntity(Long id, String type, String image, List<SalePostEntity> postEntities) {
        this.id = id;
        this.type = type;
        this.image = image;
        this.postEntities = postEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<SalePostEntity> getPostEntities() {
        return postEntities;
    }

    public void setPostEntities(List<SalePostEntity> postEntities) {
        this.postEntities = postEntities;
    }
}
