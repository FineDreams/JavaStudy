package com.yy.admin.dao;

import com.yy.admin.domain.Admin;
import com.yy.role.domain.Module;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> queryAll(Map<String, Object> map);

    int queryDataCount(Map<String, Object> map);

    void insertAdmin(Admin admin);

    void insertAdminRole(Map<String, Object> map);

    void updateById(Map<String, Object> map);

    void deleteByAdminId(Integer adminId);

    void deleteAdminId(int adminId);

    List<Module> findModulesByAdmin(Integer adminId);

    Admin findByCode(String adminCode);

}