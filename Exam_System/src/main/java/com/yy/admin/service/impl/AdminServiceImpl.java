package com.yy.admin.service.impl;

import com.yy.admin.dao.AdminMapper;
import com.yy.admin.domain.Admin;
import com.yy.admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin selectByCode(String adname) {
        Admin admin=adminMapper.queryByAdName(adname);
        return admin;
    }
}
