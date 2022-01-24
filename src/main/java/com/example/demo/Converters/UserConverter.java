package com.example.demo.Converters;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    BuyOrderConverter buyOrderConverter;
    @Autowired
    BuyPostConverter buyPostConverter;


    public UserModel basicEntityToModel(UserEntity userEntity) {
        return new UserModel(
                userEntity.getId(), userEntity.getName(), userEntity.getPassword()
                , userEntity.getLocation(), userEntity.getMobile(), userEntity.getImage()
                , userEntity.getCreated_at(), userEntity.getRate(), userEntity.getNum_reports()
                , null, null, null);
    }

    public UserModel entityToModel(UserEntity userEntity) {
        return new UserModel(
                userEntity.getId(), userEntity.getName(), userEntity.getPassword()
                , userEntity.getLocation(), userEntity.getMobile(), userEntity.getImage()
                , userEntity.getCreated_at(), userEntity.getRate(), userEntity.getNum_reports(),
                salePostConverter.basicEntityListToModelList(userEntity.getSalePosts()),
                buyOrderConverter.basicEntityListToModelList(userEntity.getBuyOrders()),
                buyPostConverter.basicEntityListToModelList(userEntity.getBuyPosts())
        );
    }

    public UserEntity basicModelToEntity(UserModel model) {
        return new UserEntity(
                model.getId(), model.getName(), model.getPassword()
                , model.getLocation(), model.getMobile(), model.getImage()
                , model.getCreated_at(), model.getRate(), model.getNum_reports()
                , null, null, null);

    }


    public UserEntity modelToEntity(UserModel model) {
        return new UserEntity(
                model.getId(), model.getName(), model.getPassword(),
                model.getLocation(), model.getMobile(), model.getImage(),
                model.getCreated_at(), model.getRate(), model.getNum_reports(),
                salePostConverter.modelListToEntityList(model.getSalePosts()),
                buyOrderConverter.modelListToEntityList(model.getBuyOrders()),
                buyPostConverter.modelListToEntityList(model.getBuyPosts())
        );
    }
}
