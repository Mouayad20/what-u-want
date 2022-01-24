package com.example.demo.Controllers;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.SignInModel;
import com.example.demo.Models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(
            @RequestBody UserModel userModel) {
        return userService.signUp(userModel);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(
            @RequestBody SignInModel signInModel) {
        return userService.signIn(signInModel);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(
            @RequestBody UserModel userModel) {
        return userService.update(userModel);
    }

    @DeleteMapping("/delete")
    public boolean delete(
            @RequestHeader("Authorization") String token) {
        return userService.delete(token.substring("Bearer ".length()));
    }

    @GetMapping("/getFormat")
    public UserEntity getFormat() {
        return new UserEntity();
    }

    @GetMapping("/fetchUserInfo")
    public UserModel fetchUserInfo(
            @RequestHeader("Authorization") String token) {
        return userService.fetchUserInfo(token.substring("Bearer ".length()));
    }

//    @GetMapping("/fetchUserInfoByUID")
//    public UserModel fetchUserInfoByUId(
//            @RequestHeader("u_id") Long u_id) {
//        return userService.fetchUserInfoByUId(u_id);
//    }

    @GetMapping("/reportUser")
    public boolean reportUser(
            @RequestHeader("u_id") Long u_id) {
        return userService.reportUser(u_id);
    }

    @GetMapping("/rateUser/rate={rate}")
    public boolean rateUser(
            @RequestHeader("u_id") Long u_id,
            @PathVariable(name = "rate") int rate) {

        return userService.rateUser(u_id, rate);
    }



}
