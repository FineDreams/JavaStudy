package com.yy.user.controller;

import com.yy.user.dao.UserMapper;
import com.yy.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/tor")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/register")
    public String register(User user){
        userMapper.insertUser(user);
        return "login";
    }

    @RequestMapping(value = "/loginUser")
    public String login(User user){
        User userByName = userMapper.findUserByName(user.getUsername());
        System.out.println(userByName.toString());
        if ((userByName.getPassword()).equals(user.getPassword())){
            return "home";
        }
        return "login";
    }


}
