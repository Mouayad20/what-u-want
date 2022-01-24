package com.example.demo.Converters;

import com.example.demo.Entities.SaleOperationEntity;
import com.example.demo.Models.SaleOperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOperationConverter {

    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    BuyOrderConverter buyOrderConverter;
    @Autowired
    BuyPostConverter buyPostConverter;
    @Autowired
    DeliveryOperationConverter deliveryOperationConverter;


    public SaleOperationModel basicEntityToModel(SaleOperationEntity saleOperation) {
        return new SaleOperationModel(
                saleOperation.getId(),
                saleOperation.getCreated_at(),
                saleOperation.isIs_done(),
                salePostConverter.basicEntityToModel(saleOperation.getSalePost()),
                buyPostConverter.basicEntityToModel(saleOperation.getBuyPost()),
                buyOrderConverter.basicEntityToModel(saleOperation.getBuyOrder()),
                null
        );

    }

    public SaleOperationModel entityToModel(SaleOperationEntity saleOperation) {
        return new SaleOperationModel(
                saleOperation.getId(),
                saleOperation.getCreated_at(),
                saleOperation.isIs_done(),
                salePostConverter.basicEntityToModel(saleOperation.getSalePost()),
                buyPostConverter.basicEntityToModel(saleOperation.getBuyPost()),
                buyOrderConverter.basicEntityToModel(saleOperation.getBuyOrder()),
                deliveryOperationConverter.entityListToModelList(saleOperation.getDeliveryOperations())
        );
    }

    public SaleOperationEntity modelToEntity(SaleOperationModel saleOperation) {
        return new SaleOperationEntity(
                saleOperation.getId(),
                saleOperation.getCreated_at(),
                saleOperation.isIs_done(),
                salePostConverter.modelToEntity(saleOperation.getSalePost()),
                buyPostConverter.modelToEntity(saleOperation.getBuyPost()),
                buyOrderConverter.modelToEntity(saleOperation.getBuyOrder()),
                deliveryOperationConverter.modelListToEntityList(saleOperation.getDeliveryOperations())
        );
    }
}
