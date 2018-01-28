package com.yy.study.web;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.study.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends ActionSupport {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String add(){
        userService.add();
        return SUCCESS;
    }

}
