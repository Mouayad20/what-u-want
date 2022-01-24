package com.example.demo.Converters;

import com.example.demo.Entities.BuyPostEntity;
import com.example.demo.Models.BuyPostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyPostConverter {

    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    UserConverter userConverter;
    @Autowired
    SaleOperationConverter saleOperationConverter;


    public List<BuyPostModel> basicEntityListToModelList(List<BuyPostEntity> entities) {
        List<BuyPostModel> models = new ArrayList<>();
        if (entities != null) {
            for (BuyPostEntity entity : entities) {
                models.add(basicEntityToModel(entity));
            }
        }
        return models;
    }

    public List<BuyPostModel> entityListToModelList(List<BuyPostEntity> entities) {
        List<BuyPostModel> models = new ArrayList<>();
        if (entities != null) {
            for (BuyPostEntity entity : entities) {
                models.add(entityToModel(entity));
            }
        }
        return models;
    }

    public List<BuyPostEntity> modelListToEntityList(List<BuyPostModel> models) {
        List<BuyPostEntity> entities = new ArrayList<>();
        if (models != null) {
            for (BuyPostModel model:models) {
                entities.add(modelToEntity(model));
            }
        }
        return entities;
    }

    public BuyPostModel entityToModel(BuyPostEntity buyPostEntity) {

        return new BuyPostModel(
                buyPostEntity.getId(), buyPostEntity.getContent(),
                buyPostEntity.getCreated_at(), buyPostEntity.isIs_hidden(),
                userConverter.basicEntityToModel(buyPostEntity.getNeedy()),
                salePostConverter.entityListToModelList(buyPostEntity.getSalePosts()),
                saleOperationConverter.entityToModel(buyPostEntity.getSaleOperation()));
    }

    public BuyPostModel basicEntityToModel(BuyPostEntity buyPostEntity) {
        return new BuyPostModel(
                buyPostEntity.getId(), buyPostEntity.getContent(),
                buyPostEntity.getCreated_at(), buyPostEntity.isIs_hidden(),
                userConverter.basicEntityToModel(buyPostEntity.getNeedy()),
                null, null);
    }

    public BuyPostEntity basicModelToEntity(BuyPostModel buyPost) {
        return new BuyPostEntity(
                buyPost.getId(),
                buyPost.getContent(),
                buyPost.getCreated_at(),
                buyPost.isIs_hidden(),
                userConverter.basicModelToEntity(buyPost.getNeedy()),
                new ArrayList<>(),
                null
        );
    }

    public BuyPostEntity modelToEntity(BuyPostModel buyPost) {
        return new BuyPostEntity(
                buyPost.getId(),
                buyPost.getContent(),
                buyPost.getCreated_at(),
                buyPost.isIs_hidden(),
                userConverter.modelToEntity(buyPost.getNeedy()),
                salePostConverter.modelListToEntityList(buyPost.getSalePosts()),
                saleOperationConverter.modelToEntity(buyPost.getSaleOperation())
        );
    }
}
