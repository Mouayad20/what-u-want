package com.example.demo.services;

import com.example.demo.Converters.BuyOrderConverter;
import com.example.demo.Converters.BuyPostConverter;
import com.example.demo.Converters.SalePostConverter;
import com.example.demo.Converters.UserConverter;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.SignInModel;
import com.example.demo.Models.UserModel;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenUtil tokenUtil;


    //////          Converters          //////
    @Autowired
    UserConverter userConverter;
    @Autowired
    SalePostConverter salePostConverter;
    @Autowired
    BuyOrderConverter buyOrderConverter;
    @Autowired
    BuyPostConverter buyPostConverter;


    public ResponseEntity<Object> signUp(UserModel userModel) {

        if (userRepository.findByMobile(userModel.getMobile()) != null && userRepository.findByMobile(userModel.getMobile()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("This mobile phone number is used");
        } else if (userRepository.findByPassword(userModel.getPassword()) != null && userRepository.findByPassword(userModel.getPassword()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Enter another password");
        } else {
            UserEntity userEntity =
                    userRepository.save(
                            new UserEntity(
                                    null, userModel.getName(), userModel.getPassword(),
                                    userModel.getLocation(), userModel.getMobile(), userModel.getImage(),
                                    new Date(), 25, 0, null, null, null
                            )
                    );


            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Authorization", "Bearer " + tokenUtil.generateToken(userEntity.getMobile()))
                    .body(
                            new UserModel(
                                    userEntity.getId(), userEntity.getName(), userEntity.getPassword(),
                                    userEntity.getLocation(), userEntity.getMobile(), userEntity.getImage(),
                                    userEntity.getCreated_at(), userEntity.getRate(), userEntity.getNum_reports(),
                                    null, null, null
                            )
                    );
        }

    }

    public ResponseEntity<Object> signIn(SignInModel signInModel) {
        UserEntity userEntity;
        if (userRepository.findByMobile(signInModel.getMobile()).isPresent()) {
            userEntity = userRepository.findByMobile(signInModel.getMobile()).get();
            if (userRepository.findByPassword(signInModel.getPassword()).isPresent() &&
                    userEntity.getId() == userRepository.findByPassword(signInModel.getPassword()).get().getId()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + tokenUtil.generateToken(userEntity.getMobile()))
                        .body(
                                new UserModel(
                                        userEntity.getId(),
                                        userEntity.getName(),
                                        userEntity.getPassword(),
                                        userEntity.getLocation(),
                                        userEntity.getMobile(),
                                        userEntity.getImage(),
                                        userEntity.getCreated_at(),
                                        userEntity.getRate(),
                                        userEntity.getNum_reports(),
                                        salePostConverter.basicEntityListToModelList(userEntity.getSalePosts()),
                                        buyOrderConverter.basicEntityListToModelList(userEntity.getBuyOrders()),
                                        buyPostConverter.basicEntityListToModelList(userEntity.getBuyPosts())
                                )
                        );
            } else return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("this password is wrong");


        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Mobile Phone Number is not exist");
        }
    }

    public UserModel fetchUserInfo(String token) {
        return userConverter.entityToModel(userRepository.findByMobile(tokenUtil.getMobileFromToken(token)).get());
    }

    public boolean reportUser(Long u_id) {
        UserEntity userEntity = userRepository.findById(u_id).get();
        userEntity.setNum_reports(userEntity.getNum_reports() + 1);
        int num = userEntity.getNum_reports();
        userEntity = userRepository.save(userEntity);
        if (userEntity.getNum_reports() == num) {
            return true;
        } else return false;
    }

    public boolean rateUser(Long u_id, int rate) {

        UserEntity userEntity = userRepository.findById(u_id).get();
        userEntity.setRate(userEntity.getRate() + rate);
        int num = userEntity.getRate();
        userEntity = userRepository.save(userEntity);
        if (userEntity.getRate() == num) {
            return true;
        } else return false;
    }

    public ResponseEntity<Object> update(UserModel userModel) {
        if (userRepository.findById(userModel.getId()).isPresent()) {
            UserEntity userEntity = userRepository.findById(userModel.getId()).get();
            if (userRepository.findByMobile(userModel.getMobile()).isPresent() && userRepository.findByMobile(userModel.getMobile()).get().getId() != userModel.getId()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .body("This mobile phone number is used from another user");
            } else if (userRepository.findByPassword(userModel.getPassword()).isPresent() && userRepository.findByPassword(userModel.getPassword()).get().getId() != userModel.getId()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .body("Enter another password this is used before");
            } else {


                userEntity.setName(userModel.getName());
                userEntity.setPassword(userModel.getPassword());
                userEntity.setLocation(userModel.getLocation());
                userEntity.setMobile(userModel.getMobile());
                userEntity.setImage(userModel.getImage());
                userEntity.setNum_reports(userModel.getNum_reports());

                UserEntity savedEntity = userRepository.save(userEntity);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + tokenUtil.generateToken(userEntity.getMobile()))
                        .body(userConverter.entityToModel(savedEntity));
            }

        }
        else
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("this user is not found");
    }


    public boolean delete(String token) {
        UserEntity userEntity = userRepository.findByMobile(tokenUtil.getMobileFromToken(token)).get();
        userRepository.delete(userEntity);
        if (userRepository.findById(userEntity.getId()).isPresent()) return false;
        else return true;
    }

//    public UserModel fetchUserInfoByUId(Long u_id) {
//        return userConverter.entityToModel(userRepository.findById(u_id).get());
//    }
}
