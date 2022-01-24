package com.example.demo.services;

import com.example.demo.Converters.BuyOrderConverter;
import com.example.demo.Converters.SalePostConverter;
import com.example.demo.Converters.UserConverter;
import com.example.demo.Entities.BuyOrderEntity;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.BuyOrderModel;
import com.example.demo.Repositories.BuyOrderRepository;
import com.example.demo.Repositories.SalePostRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BuyOrderService {

    @Autowired
    BuyOrderRepository buyOrderRepository;
    @Autowired
    SalePostRepository salePostRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    BuyOrderConverter buyOrderConverter;
    @Autowired
    UserConverter userConverter;

    public ResponseEntity<Object> add(String token, BuyOrderModel buyOrderModel) {

        BuyOrderEntity buyOrderEntity = new BuyOrderEntity();

        UserEntity userEntity = userRepository.findByMobile(tokenUtil.getMobileFromToken(token)).get();

        if (buyOrderModel.getPrice() != null)
            buyOrderEntity.setPrice(buyOrderModel.getPrice());
        buyOrderEntity.setBuyer(userEntity);
        buyOrderEntity.setCreated_at(new Date());

        if (salePostRepository.findById(buyOrderModel.getSalePost().getId()).isPresent()) {

            buyOrderEntity.setSalePost(salePostRepository.findById(buyOrderModel.getSalePost().getId()).get());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            buyOrderConverter.basicEntityToModel(
                                    buyOrderRepository.save(
                                            buyOrderEntity
                                    )
                            )
                    );
        } else
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("the sale post is gone");
    }

    public List<BuyOrderModel> fetchBuyOrdersBySID(Long p_id) {
        List<BuyOrderModel> buyOrderModels = new ArrayList<>();
        if (buyOrderRepository.getBuyOrdersBySID(p_id)!=null) {
            for (BuyOrderEntity entity : buyOrderRepository.getBuyOrdersBySID(p_id)) {
                BuyOrderModel model = new BuyOrderModel();
                model.setId(entity.getId());
                if (entity.getPrice() != null)
                    model.setPrice(entity.getPrice());
                model.setBuyer(userConverter.basicEntityToModel(entity.getBuyer()));
                model.setCreated_at(entity.getCreated_at());
                buyOrderModels.add(model);
            }
        }
        return buyOrderModels;
    }

    public boolean remove(Long order_id) {
        buyOrderRepository.deleteById(order_id);
        if (buyOrderRepository.findById(order_id).isPresent())
            return false;
        else
            return true;

    }


}
