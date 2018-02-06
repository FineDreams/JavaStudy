package com.yy.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yy.domain.User;
import com.yy.service.UserService;
import com.yy.service.exception.LoginException;
import com.yy.service.exception.PasswordErrorException;
import com.yy.service.exception.UserNameErrorException;

public class UserAction extends ActionSupport implements ModelDriven{

    private UserService userService;
    private User user=new User();


    public String register(){
        userService.add(user);
        return "register";
    }

    public String login(){
        System.out.println(user.toString());
        User userDB;
        try {
            userDB=userService.login(user);
        } catch (LoginException e) {
            addFieldError("loginError",e.getMessage());
            return "errorMsg";
        }
        ActionContext.getContext().put("user",userDB);
        return "login";
    }












    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Object getModel() {
        return user;
    }
}
