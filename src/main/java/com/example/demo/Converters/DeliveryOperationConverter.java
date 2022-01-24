package com.example.demo.Converters;

import com.example.demo.Entities.DeliveryOperationEntity;
import com.example.demo.Models.DeliveryOperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryOperationConverter {

    @Autowired
    SaleOperationConverter saleOperationConverter;
    @Autowired
    EmployeeConverter employeeConverter;

    public List<DeliveryOperationModel> entityListToModelList(List<DeliveryOperationEntity> entities) {
        List<DeliveryOperationModel> models = new ArrayList<>();
        if (entities != null) {
            for (DeliveryOperationEntity entity : entities
            ) {
                models.add(entityToModel(entity));

            }
        }
        return models;
    }

    public List<DeliveryOperationEntity> modelListToEntityList(List<DeliveryOperationModel> deliveryOperations) {
        List<DeliveryOperationEntity> list = new ArrayList<>();
        if(deliveryOperations != null){
            for (DeliveryOperationModel delivery : deliveryOperations){
                list.add(modelToEntity(delivery));
            }
        }
        return list;
    }

    public DeliveryOperationEntity modelToEntity(DeliveryOperationModel delivery) {
        return  new DeliveryOperationEntity(
                delivery.getId(),
                delivery.getOperation_type(),
                delivery.getReason(),
                delivery.getCreated_at(),
                delivery.getRate(),
                delivery.isIs_done(),
                saleOperationConverter.modelToEntity(delivery.getSaleOperation()),
                employeeConverter.modelToEntity(delivery.getEmployee())
        );
    }

    public DeliveryOperationModel entityToModel(DeliveryOperationEntity entity) {
        return new DeliveryOperationModel(entity.getId(),
                entity.getOperation_type(),
                entity.getReason(),
                entity.getCreated_at(),
                entity.getRate(),
                entity.isIs_done(),
                saleOperationConverter.entityToModel(entity.getSaleOperation()),
                employeeConverter.entityToModel(entity.getEmployee())
        );
    }
}
