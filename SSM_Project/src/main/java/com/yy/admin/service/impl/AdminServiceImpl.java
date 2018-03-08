package com.yy.admin.service.impl;

import com.yy.admin.dao.AdminMapper;
import com.yy.admin.domain.Admin;
import com.yy.admin.service.AdminService;
import com.yy.admin.service.util.AdminPageBean;
import com.yy.role.dao.ModuleMapper;
import com.yy.role.dao.RoleMapper;
import com.yy.role.domain.Module;
import com.yy.role.domain.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private ModuleMapper moduleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public AdminPageBean queryAllAdmin(AdminPageBean adminPageBean) {
        Map<String,Object> map=new HashMap<>();
        if (adminPageBean.getModuleId()!=null){
            map.put("moduleId",adminPageBean.getModuleId());
        }
        if (adminPageBean.getRoleName()!=null){
            map.put("roleName",adminPageBean.getRoleName());
        }
        int dataCount=adminMapper.queryDataCount(map);
        adminPageBean=new AdminPageBean(adminPageBean.getNowPageIndex(),dataCount);
        map.put("start",adminPageBean.getStart());
        map.put("pageSize",adminPageBean.getPageSize());
        List<Admin> adminList=adminMapper.queryAll(map);
        adminPageBean.setList(adminList);
        return adminPageBean;
    }

    @Override
    public List<Module> queryAllModule() {
        List<Module> modules=moduleMapper.queryAllModule();
        return modules;
    }

    @Override
    public void addAdmin(Admin admin) {
        List<Integer> roleIds = admin.getRoleIds();
        admin.setEnrolldate(new Date());
        adminMapper.insertAdmin(admin);
        Map<String,Object> map=new HashMap<>();
        map.put("adminId",admin.getAdminId());
        for (Integer roleId : roleIds) {
            map.put("roleId",roleId);
            adminMapper.insertAdminRole(map);
        }
    }

    @Override
    public List<Role> queryAllRole() {
        List<Role> roleList=roleMapper.queryAllRole();
        return roleList;
    }

    @Override
    public Admin queryAdminById(int adminId) {
        Admin admin = adminMapper.selectByPrimaryKey(adminId);
        return admin;
    }

    @Override
    public void modifyAdmin(Admin admin) {
        adminMapper.deleteByAdminId(admin.getAdminId());
        List<Integer> roleIds = admin.getRoleIds();
        Map<String,Object> map=new HashMap<>();
        map.put("adminId",admin.getAdminId());
        for (Integer roleId : roleIds) {
            map.put("roleId",roleId);
            adminMapper.insertAdminRole(map);
        }
    }

    @Override
    public void deleteAdminById(int adminId) {
        adminMapper.deleteAdminId(adminId);
        adminMapper.deleteByAdminId(adminId);
    }

    @Override
    public List<Module> findModulesByAdmin(Integer adminId) {
        List<Module> modules=adminMapper.findModulesByAdmin(adminId);
        return modules;
    }

    @Override
    public Admin findByCode(String adminCode) {
        Admin admin=adminMapper.findByCode(adminCode);
        return admin;
    }
}
