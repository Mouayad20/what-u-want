package com.example.demo.services;

import com.example.demo.Converters.TypeConverter;
import com.example.demo.Entities.TypeEntity;
import com.example.demo.Models.TypeModel;
import com.example.demo.Repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeConverter typeConverter;


    public ResponseEntity<Object> addType(TypeModel typeModel) {
        TypeEntity typeEntity = typeRepository.save(typeConverter.modelToEntity(typeModel));
        if (typeRepository.findById(typeEntity.getId()).isPresent())
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(typeConverter.entityToModel(typeEntity));
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Adding the type failed");
    }

    public List<TypeModel> fetchAllTypes() {
        return typeConverter.entityListToModelList(typeRepository.findAll());
    }

}

/*
public List<TypeModel> fetchAllTypes(int page , int size) {
        Pageable pageable = PageRequest.of(page,size);
        return typeConverter.entityListToModelList(typeRepository.findAll(pageable).getContent());
    }

 */
