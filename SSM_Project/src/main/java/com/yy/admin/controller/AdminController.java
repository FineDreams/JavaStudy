package com.yy.admin.controller;

import com.yy.admin.domain.Admin;
import com.yy.admin.service.AdminService;
import com.yy.admin.service.util.AdminPageBean;
import com.yy.role.domain.Module;
import com.yy.role.domain.Role;
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

    @RequestMapping("/tol")
    public String toLogin(){
        return "login";
    }

//    @RequestMapping("/login")
//    public String login(Admin admin){
//        adminMapper.insert(admin);
//        return "index";
//    }
    @RequestMapping("/toAdmin")
    public String toAdmin(Model model, AdminPageBean adminPageBean){
        adminPageBean=adminService.queryAllAdmin(adminPageBean);
        model.addAttribute("AdminPageBean",adminPageBean);
        List<Module> modules=adminService.queryAllModule();
        model.addAttribute("modules",modules);
        return "admin/admin_list";
    }

    @RequestMapping("/toAddAdmin")
    public String toAddAdmin(Model model){
        List<Role> roleList=adminService.queryAllRole();
        model.addAttribute("roleList",roleList);
//        for (Role role : roleList) {
//            System.out.println("测试role++=="+role);
//        }
        return "admin/admin_add";
    }

    @RequestMapping("/AddAdmin")
    public String AddAdmin(Admin admin){
        System.out.println("测试接收到的admin"+admin);
        adminService.addAdmin(admin);
        return "redirect:/admin/toAdmin";
    }

    @RequestMapping("/toModifyAdmin")
    public String toModifyAdmin(Model model,int adminId){
        Admin admin=adminService.queryAdminById(adminId);
        model.addAttribute("admin",admin);
        System.out.println(admin);
        List<Role> roleList = adminService.queryAllRole();
        model.addAttribute("roleList",roleList);
        return "admin/admin_modi";
    }

    @RequestMapping("/modifyAdmin")
    public String ModifyAdmin(Admin admin){
        adminService.modifyAdmin(admin);
        return "redirect:/admin/toAdmin";
    }

    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(int adminId){
        System.out.println("测试adminId======"+adminId);
        adminService.deleteAdminById(adminId);
        return "redirect:/admin/toAdmin";
    }
}
