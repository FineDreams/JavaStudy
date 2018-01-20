package com.yy.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.user.domain.User;
import com.yy.user.service.UserService;
import com.yy.user.service.exception.PassWordErrorException;
import com.yy.user.service.exception.UserException;
import com.yy.user.service.exception.UserNameNoneException;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport {

    private User user;
    private UserService userService=new UserService();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login(){
        User userFromDB=new User();
        try {
            userFromDB = userService.searchByUname(this.user);
        } catch (UserException e) {
            addFieldError("loginError",e.getMessage());
            return "input";
        }
        ServletActionContext.getRequest().getSession().setAttribute("username",userFromDB.getUsername());
        return "login";
    }
    
}
