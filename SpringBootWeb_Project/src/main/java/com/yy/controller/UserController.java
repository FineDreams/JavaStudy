package com.yy.controller;

import com.yy.domain.Article;
import com.yy.domain.User;
import com.yy.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        User user = userService.selectUserByName("aaa");
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "regest";
    }
    @RequestMapping("/isExit")
    @ResponseBody
    public Object isExit(@Param("phone")String phone){
        User user=userService.selectUserByPhone(phone);
        return user;
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Object selectUser(@Param("userName")String userName){
        User user = userService.selectUserByName(userName);
        return user;
    }

    @RequestMapping("/Register")
    public String Register(User user){
        userService.insertUser(user);
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public User login(Model model,@Param("phone")String phone,@Param("password")String password){
        User user=userService.selectUserByLogin(phone,password);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/toIndex")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/selectAllArticle")
    public List<Article> selectAllArticle(){
        List<Article> articleList=userService.selectAllArticle();

        return articleList;
    }

    @RequestMapping("/toDetail")
    public String toDetail(){
        return "pro_detail";
    }

    @ResponseBody
    @RequestMapping("/queryDetail")
    public Article articleDetail(@Param("goodsId")int goodsId){
        System.out.println("测试id"+goodsId);
        Article article=userService.queryByGoodId(goodsId);
        return article;
    }

}
