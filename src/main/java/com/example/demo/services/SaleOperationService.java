package com.example.demo.services;

import com.example.demo.Converters.SaleOperationConverter;
import com.example.demo.Entities.SaleOperationEntity;
import com.example.demo.Models.SaleOperationModel;
import com.example.demo.Repositories.SaleOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleOperationService {

    @Autowired
    SaleOperationRepository saleOperationRepository;
    @Autowired
    SaleOperationConverter saleOperationConverter;

    public ResponseEntity<Object> create(SaleOperationModel saleOperationModel) {

        SaleOperationEntity saleOperationEntity = saleOperationRepository.save(saleOperationConverter.modelToEntity(saleOperationModel));
        if (saleOperationRepository.findById(saleOperationEntity.getId()).isPresent())
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(saleOperationConverter.entityToModel(saleOperationEntity));
        else
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body("The create sale operation is failed try again later ");

    }
}
