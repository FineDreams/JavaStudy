package com.ty.admin.service.impl;

import com.ty.admin.dao.AdminMapper;
import com.ty.admin.domain.Admin;
import com.ty.admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin queryAdminByName(String adminCode) {
        Admin admin=adminMapper.queryAdminByName(adminCode);
        return admin;
    }
}
