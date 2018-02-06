package com.yy.netctoss.admin.dao;

import com.yy.netctoss.admin.domain.Admin_info;

public interface Admin_infoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin_info record);

    int insertSelective(Admin_info record);

    Admin_info selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin_info record);

    int updateByPrimaryKey(Admin_info record);
}