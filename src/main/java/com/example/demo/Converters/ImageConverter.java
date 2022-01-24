package com.example.demo.Converters;

import com.example.demo.Entities.ImageEntity;
import com.example.demo.Models.ImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageConverter {

    @Autowired
    SalePostConverter salePostConverter;


    public List<ImageModel> entityListToModelList(List<ImageEntity> entities) {
        List<ImageModel> models = new ArrayList<>();
        if (entities != null) {
            for (ImageEntity entity : entities
            ) {
                models.add(entityToModel(entity));
            }
        }
        return models;
    }

    public List<ImageModel> basicEntityListToModelList(List<ImageEntity> entities) {
        List<ImageModel> models = new ArrayList<>();
        if (entities != null) {
            for (ImageEntity entity : entities
            ) {
                models.add(basicEntityToModel(entity));
            }
        }
        return models;
    }

    public ImageModel entityToModel(ImageEntity imageEntity) {
        return new ImageModel(
                imageEntity.getId(),
                imageEntity.getPath(),
                salePostConverter.basicEntityToModel(imageEntity.getSalePost()));
    }

    public ImageModel basicEntityToModel(ImageEntity imageEntity) {

        return new ImageModel(
                imageEntity.getId(),
                imageEntity.getPath(),null);
    }


    public ImageEntity modelToEntity(ImageModel model){
        ImageEntity image = new ImageEntity();
        image.setId(model.getId());
        image.setPath(model.getPath());
        image.setSalePost(salePostConverter.basicModelToEntity(model.getSalePost()));
        return image;
    }
    public ImageEntity basicModelToEntity(ImageModel model){
        ImageEntity image = new ImageEntity();
        image.setId(model.getId());
        image.setPath(model.getPath());
        return image;
    }

    public List<ImageEntity> modelListToEntityList(List<ImageModel> models){
        List<ImageEntity> list = new ArrayList<>();
        for (ImageModel model:models
             ) {
            list.add(modelToEntity(model));
        }
        return list;

    }

    public List<ImageEntity> basicModelListToEntityList(List<ImageModel> models){
        List<ImageEntity> list = new ArrayList<>();
        for (ImageModel model:models
             ) {
            list.add(basicModelToEntity(model));
        }
        return list;

    }

}
