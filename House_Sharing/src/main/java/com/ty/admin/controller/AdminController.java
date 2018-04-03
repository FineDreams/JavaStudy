package com.ty.admin.controller;

import com.ty.admin.service.AdminService;
import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

//    @RequestMapping("toIndex")
//    public String toIndex(){
//        return "main/index";
//    }

    @RequestMapping("/queryAllUser")
    public String queryAllUser(Model model,PageBean<User> pageBean){
        pageBean = adminService.queryAllUser(pageBean);
        model.addAttribute("pageBean",pageBean);
        return "admin/admin_all_user";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int uid){
        adminService.deleteUserById(uid);
        return "redirect:queryAllUser";
    }
    @RequestMapping("/queryAllRentals")
    public String queryAllRental(Model model,PageBean pageBean){
        PageBean pageBean1=adminService.queryAllRental(pageBean);
        model.addAttribute("pageBean",pageBean1);
        return "admin/admin_all_rental";
    }
    @RequestMapping("/deleteRental")
    public String deleteRental(int rid){
        adminService.deleteRentalByRid(rid);
        return "redirect:queryAllUser";
    }
}
