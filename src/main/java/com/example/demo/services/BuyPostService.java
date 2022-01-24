package com.example.demo.services;

import com.example.demo.Converters.BuyPostConverter;
import com.example.demo.Models.BuyPostModel;
import com.example.demo.Repositories.BuyPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BuyPostService {

    @Autowired
    BuyPostRepository buyPostRepository;
    @Autowired
    BuyPostConverter buyPostConverter;

    public BuyPostModel create(BuyPostModel buyPostModel) {
        buyPostModel.setCreated_at(new Date());
        return buyPostConverter.entityToModel(
                buyPostRepository.save(
                        buyPostConverter.modelToEntity(
                                buyPostModel
                        )
                )
        );
    }

    public BuyPostModel update(BuyPostModel buyPostModel) {
        return buyPostConverter.entityToModel(
                buyPostRepository.save(
                        buyPostConverter.modelToEntity(
                                buyPostModel
                        )
                )
        );
    }

    public boolean delete(Long o_id) {
        buyPostRepository.deleteById(o_id);
        if (buyPostRepository.findById(o_id).isPresent()) return false;
        else return true;
    }

    public List<BuyPostModel> fetchByType() {
        return buyPostConverter.entityListToModelList(buyPostRepository.findAll());
    }
}
