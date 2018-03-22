package com.yy.web.controller;

import com.yy.domain.Msg;
import com.yy.domain.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        SecurityContext context= SecurityContextHolder.getContext();
        Authentication auth=context.getAuthentication();
        SysUser user= (SysUser) auth.getPrincipal();
        System.out.println(user.getRoles().get(0).getName());
        Msg msg=new Msg("我是标题","我是内容","额外信息，只有管理员可看到");
        model.addAttribute("msg",msg);
        return "home";
    }

}
