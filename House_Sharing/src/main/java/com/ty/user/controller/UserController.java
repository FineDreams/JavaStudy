package com.ty.user.controller;

import com.ty.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("toInfo")
    public String toInfo(){
        return "user/user_info";
    }
}
