package com.yy.role.service.impl;

import com.yy.role.dao.ModuleMapper;
import com.yy.role.dao.RoleMapper;
import com.yy.role.domain.Module;
import com.yy.role.domain.Role;
import com.yy.role.service.RoleService;
import com.yy.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public PageBean queryAllRole(PageBean pageBean) {
        Map<String,Object> map=new HashMap<>();
        int dataCount=roleMapper.queryDataCount();
        PageBean rolePageBean=new PageBean(pageBean.getNowPageIndex(),dataCount);
        map.put("start",rolePageBean.getStart());
        map.put("pageSize",rolePageBean.getPageSize());
        List<Role> roleList=roleMapper.queryByGroup(map);
//        for (Role role : roleList) {
//            System.out.println("测试role"+role);
//        }
        rolePageBean.setList(roleList);
        return rolePageBean;
    }

    @Override
    public Role queryRoleById(int roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        System.out.println(role);
        return role;
    }

    @Override
    public List<Module> queryAllModule() {
        List<Module> modules=moduleMapper.queryAllModule();
        return modules;
    }
}
