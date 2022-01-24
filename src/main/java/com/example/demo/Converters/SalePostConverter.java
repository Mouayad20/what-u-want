package com.example.demo.Converters;

import com.example.demo.Entities.ImageEntity;
import com.example.demo.Entities.SalePostEntity;
import com.example.demo.Models.ImageModel;
import com.example.demo.Models.SalePostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalePostConverter {


    @Autowired
    UserConverter userConverter;
    @Autowired
    BuyOrderConverter buyOrderConverter;
    @Autowired
    BuyPostConverter buyPostConverter;
    @Autowired
    TypeConverter typeConverter;
    @Autowired
    ImageConverter imageConverter;

    public List<SalePostModel> entityListToModelList(List<SalePostEntity> entities) {
        List<SalePostModel> models = new ArrayList<>();
        if (entities != null) {
            for (SalePostEntity entity : entities) {
                models.add(entityToModel(entity));
            }
        }
        return models;
    }

    public List<SalePostModel> basicEntityListToModelList(List<SalePostEntity> entities) {
        List<SalePostModel> models = new ArrayList<>();
        if (entities != null) {
            for (SalePostEntity entity : entities) {
                models.add(basicEntityToModel(entity));
            }
        }
        return models;
    }

    public List<SalePostEntity> modelListToEntityList(List<SalePostModel> models) {
        List<SalePostEntity> entities = new ArrayList<>();
        if (models != null) {
            for (SalePostModel model : models) {
                entities.add(modelToEntity(model));
            }
        }
        return entities;
    }

    public List<SalePostEntity> basicModelListToEntityList(List<SalePostModel> models) {
        List<SalePostEntity> entities = new ArrayList<>();
        if (models != null) {
            for (SalePostModel model : models) {
                entities.add(basicModelToEntity(model));
            }
        }
        return entities;

    }

    public SalePostEntity modelToEntity(SalePostModel model) {

        SalePostEntity entity = new SalePostEntity();

        entity.setId(model.getId());
        entity.setPost_type(model.getPost_type());
        entity.setPost_status(model.getPost_status());
        entity.setItem_name(model.getItem_name());
        entity.setItem_price(model.getItem_price());
        entity.setItem_status(model.getItem_status());
        entity.setCreated_at(model.getCreated_at());
        entity.setIs_hidden(model.isIs_hidden());

        if (model.getSeller() != null) entity.setSeller(userConverter.basicModelToEntity(model.getSeller()));
        if (model.getBuyPost() != null) entity.setBuyPost(buyPostConverter.basicModelToEntity(model.getBuyPost()));
        if (model.getBuyOrders() != null)
            entity.setBuyOrders(buyOrderConverter.modelListToEntityList(model.getBuyOrders()));
        if (model.getItem_type() != null) entity.setItem_type(typeConverter.modelToEntity(model.getItem_type()));
        if (model.getImages() != null){
            for (ImageModel image: model.getImages()) {
                image.setSalePost(model);
                entity.getImages().add(new ImageEntity(null,image.getPath(),entity));
            }
        }


        return entity;

    }

    public SalePostEntity basicModelToEntity(SalePostModel model) {

        SalePostEntity entity = new SalePostEntity();

        entity.setId(model.getId());
        entity.setPost_type(model.getPost_type());
        entity.setPost_status(model.getPost_status());
        entity.setItem_name(model.getItem_name());
        entity.setItem_price(model.getItem_price());
        entity.setItem_status(model.getItem_status());
        entity.setIs_hidden(model.isIs_hidden());
        entity.setCreated_at(model.getCreated_at());

        return entity;

    }

    public SalePostModel entityToModel(SalePostEntity salePostEntity) {

        SalePostModel salePostModel = new SalePostModel();

        salePostModel.setId(salePostEntity.getId());
        salePostModel.setPost_type(salePostEntity.getPost_type());
        salePostModel.setPost_status(salePostEntity.getPost_status());
        salePostModel.setItem_name(salePostEntity.getItem_name());
        salePostModel.setItem_price(salePostEntity.getItem_price());
        salePostModel.setItem_status(salePostEntity.getItem_status());
        salePostModel.setCreated_at(salePostEntity.getCreated_at());
        salePostModel.setIs_hidden(salePostEntity.isIs_hidden());
        if (salePostEntity.getSeller() != null)
            salePostModel.setSeller(userConverter.basicEntityToModel(salePostEntity.getSeller()));
        if (salePostEntity.getBuyPost() != null)
            salePostModel.setBuyPost(buyPostConverter.basicEntityToModel(salePostEntity.getBuyPost()));
        if (salePostEntity.getBuyOrders() != null)
            salePostModel.setBuyOrders(buyOrderConverter.basicEntityListToModelList(salePostEntity.getBuyOrders()));
        if (salePostEntity.getItem_type() != null)
            salePostModel.setItem_type(typeConverter.basicEntityToModel(salePostEntity.getItem_type()));
        if(salePostEntity.getImages()!=null)
            salePostModel.setImages(imageConverter.basicEntityListToModelList(salePostEntity.getImages()));

        return salePostModel;
    }

    public SalePostModel basicEntityToModel(SalePostEntity salePostEntity) {
        return new SalePostModel(
                salePostEntity.getId(),
                salePostEntity.getPost_type(),
                salePostEntity.getPost_status(),
                salePostEntity.getItem_name(),
                salePostEntity.getItem_price(),
                typeConverter.basicEntityToModel(salePostEntity.getItem_type()),
                salePostEntity.getItem_status(),
                salePostEntity.getCreated_at(),
                salePostEntity.isIs_hidden(),
                userConverter.basicEntityToModel(salePostEntity.getSeller()),
                null, new ArrayList<>(),
                new ArrayList<>(),
                null
        );
    }


}
