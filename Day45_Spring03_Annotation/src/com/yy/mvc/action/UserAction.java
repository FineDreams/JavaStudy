package com.yy.mvc.action;


import com.yy.annotation.UserDao;
import com.yy.annotation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserAction {
    @Resource
    private UserService userService;


}
