package com.yy.study.web.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.study.service.UserService;

public class UserAction extends ActionSupport {
    private UserService userService=new UserService();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String register(){
        userService.register();

        return SUCCESS;
    }
}




