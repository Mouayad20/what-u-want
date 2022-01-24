package com.example.demo.services;

import com.example.demo.Converters.ImageConverter;
import com.example.demo.Converters.SalePostConverter;
import com.example.demo.Entities.SalePostEntity;
import com.example.demo.Models.ImageModel;
import com.example.demo.Models.SalePostModel;
import com.example.demo.Repositories.SalePostRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalePostService {

    @Autowired
    SalePostRepository salePostRepository;
    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenUtil tokenUtil;

    public SalePostModel create(String token, SalePostModel salePostModel) {

        SalePostEntity salePostEntity = salePostConverter.modelToEntity(salePostModel);

        salePostEntity.setSeller(userRepository.findByMobile(tokenUtil.getMobileFromToken(token)).get());
        salePostEntity.setCreated_at(new Date());

        return salePostConverter.entityToModel(salePostRepository.save(salePostEntity));
    }

    public List<SalePostModel> fetchByType(Long t_id) {
        return salePostConverter.entityListToModelList(salePostRepository.fetchByType(t_id));
    }

    public boolean delete(Long p_id) {
        salePostRepository.deleteById(p_id);
        if (salePostRepository.findById(p_id).isPresent()) return false;
        else return true;
    }

    public SalePostModel update(SalePostModel salePostModel) {
        salePostModel.setCreated_at(new Date());
        return salePostConverter.entityToModel(salePostRepository.save(salePostConverter.modelToEntity(salePostModel)));
    }

}
