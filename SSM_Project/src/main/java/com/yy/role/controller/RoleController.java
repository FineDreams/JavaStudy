package com.yy.role.controller;

import com.yy.role.domain.Module;
import com.yy.role.domain.Role;
import com.yy.role.service.RoleService;
import com.yy.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/toRoleModule")
    public String toRoleModule(){
        return "role/role_list";
    }

    @RequestMapping("/roleList")
    public String roleList(Model model, PageBean pageBean){
        PageBean rolePageBean=roleService.queryAllRole(pageBean);
        model.addAttribute("rolePageBean",rolePageBean);
        return "role/role_list";
    }

    @RequestMapping("/toModifyRole")
    public String toModifyRole(Model model,int roleId){
        List<Module> modules=roleService.queryAllModule();
        Role role=roleService.queryRoleById(roleId);
        model.addAttribute("modules",modules);
        model.addAttribute("role",role);
        return "role/role_modi";

    }

    @RequestMapping("/modifyRole")
    public String modifyRole(Role role){
        return "redirect:roleList";
    }

    @RequestMapping("/toAddRole")
    public String toAddRole(){
        return "role/role_add";
    }

}
