package com.yy.role.service;

import com.yy.role.domain.Module;
import com.yy.role.domain.Role;
import com.yy.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleService {
    PageBean queryAllRole(PageBean pageBean);

    Role queryRoleById(int roleId);

    List<Module> queryAllModule();

}
