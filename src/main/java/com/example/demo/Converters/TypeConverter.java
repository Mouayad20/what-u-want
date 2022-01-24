package com.example.demo.Converters;

import com.example.demo.Entities.TypeEntity;
import com.example.demo.Models.TypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeConverter {

    @Autowired
    SalePostConverter salePostConverter;


    public TypeModel basicEntityToModel(TypeEntity item_type) {
        return new TypeModel(
                item_type.getId(),
                item_type.getType(),
                item_type.getImage(),
                new ArrayList<>()
        );
    }

    public TypeModel entityToModel(TypeEntity item_type) {
        return new TypeModel(
                item_type.getId(),
                item_type.getType(),
                item_type.getImage(),
                salePostConverter.entityListToModelList(item_type.getPostEntities())
        );
    }

    public TypeEntity modelToEntity(TypeModel item_type) {
        return new TypeEntity(
                item_type.getId(),
                item_type.getType(),
                item_type.getImage(),
                salePostConverter.modelListToEntityList(item_type.getSalePosts())
        );
    }

    public List<TypeModel> entityListToModelList(List<TypeEntity> types) {
        List<TypeModel> list = new ArrayList<>();
        if (types!=null){
            for (TypeEntity type :types) {
                list.add(entityToModel(type));
            }
        }
        return list;
    }
}
