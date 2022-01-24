package com.example.demo.Converters;

import com.example.demo.Entities.BuyOrderEntity;
import com.example.demo.Models.BuyOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BuyOrderConverter {

    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    UserConverter userConverter;
    @Autowired
    SaleOperationConverter saleOperationConverter;


    public List<BuyOrderModel> entityListToModelList(List<BuyOrderEntity> entities) {
        List<BuyOrderModel> models = new ArrayList<>();
        if (entities != null) {
            for (BuyOrderEntity entity : entities) {
                models.add(entityToModel(entity));
            }
        }
        return models;
    }

    public List<BuyOrderModel> basicEntityListToModelList(List<BuyOrderEntity> entities) {
        List<BuyOrderModel> models = new ArrayList<>();
        for (BuyOrderEntity entity : entities) {
            models.add(basicEntityToModel(entity));
        }
        return models;
    }

    public List<BuyOrderEntity> modelListToEntityList(List<BuyOrderModel> buyOrders) {

        List<BuyOrderEntity> list = new ArrayList<>();
        if (buyOrders != null) {
            for (BuyOrderModel buyOrder : buyOrders) {
                list.add(modelToEntity(buyOrder));
            }
        }

        return list;

    }

    public BuyOrderEntity modelToEntity(BuyOrderModel buyOrder) {
        BuyOrderEntity entity = new BuyOrderEntity();

        entity.setId(buyOrder.getId());
        entity.setPrice(buyOrder.getPrice());
        entity.setCreated_at(buyOrder.getCreated_at());
        if (buyOrder.getBuyer() != null)
            entity.setBuyer(userConverter.modelToEntity(buyOrder.getBuyer()));
        if (buyOrder.getSalePost() != null)
            entity.setSalePost(salePostConverter.modelToEntity(buyOrder.getSalePost()));
        if (buyOrder.getSaleOperation() != null)
            entity.setSaleOperation(saleOperationConverter.modelToEntity(buyOrder.getSaleOperation()));

        return entity;


    }

    public BuyOrderModel entityToModel(BuyOrderEntity entity) {
        return new BuyOrderModel(
                entity.getId(),
                entity.getPrice(),
                entity.getCreated_at(),
                userConverter.entityToModel(entity.getBuyer()),
                salePostConverter.entityToModel(entity.getSalePost()),
                saleOperationConverter.entityToModel(entity.getSaleOperation())
        );
    }

    public BuyOrderModel basicEntityToModel(BuyOrderEntity buyOrderEntity) {
        return new BuyOrderModel(
                buyOrderEntity.getId(),
                buyOrderEntity.getPrice(),
                buyOrderEntity.getCreated_at(),
                null,null,null);
    }


}
