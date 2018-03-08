package com.yy.admin.service;

import com.yy.admin.domain.Admin;
import com.yy.admin.service.util.AdminPageBean;
import com.yy.role.domain.Module;
import com.yy.role.domain.Role;

import java.util.List;

public interface AdminService {

    AdminPageBean queryAllAdmin(AdminPageBean adminPageBean);

    List<Module> queryAllModule();

    void addAdmin(Admin admin);

    List<Role> queryAllRole();

    Admin queryAdminById(int adminId);

    void modifyAdmin(Admin admin);

    void deleteAdminById(int adminId);

    List<Module> findModulesByAdmin(Integer adminId);

    Admin findByCode(String adminCode);

}
