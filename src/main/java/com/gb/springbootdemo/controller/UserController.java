package com.gb.springbootdemo.controller;

import com.gb.springbootdemo.bean.User;
import com.gb.springbootdemo.propertites.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    GirlProperties girlProperties;

    @GetMapping("/getuser")
    public User getUser() {
        User user = new User();
        user.setUsername("xiaoming");
        user.setPassword("1213456");
        return user;
    }

    @GetMapping("/user")
    public String getUserName() {
        return girlProperties.getAge() + "," + girlProperties.getCupSize();
    }

}
