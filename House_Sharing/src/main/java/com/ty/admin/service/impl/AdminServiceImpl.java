package com.ty.admin.service.impl;

import com.ty.admin.dao.AdminMapper;
import com.ty.admin.domain.Admin;
import com.ty.admin.service.AdminService;
import com.ty.user.dao.RentalMapper;
import com.ty.user.dao.UserMapper;
import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RentalMapper rentalMapper;

    @Override
    public Admin queryAdminByName(String adminCode) {
        Admin admin=adminMapper.queryAdminByName(adminCode);
        return admin;
    }

    @Override
    public PageBean queryAllUser(PageBean pageBean) {
        int dataCount=userMapper.queryDataCount();
        pageBean=new PageBean(pageBean.getNowPageIndex(),dataCount);
        Map<String,Object> map=new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<User> userList=userMapper.queryUserGroup(map);
        pageBean.setList(userList);
        return pageBean;
    }

    @Override
    public void deleteUserById(int uid) {
        List<Rental> rentalList=rentalMapper.selectRentalByUid(uid);
        for (Rental rental : rentalList) {
            rentalMapper.deleteByPrimaryKey(rental.getRid());
        }
        userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public PageBean queryAllRental(PageBean pageBean) {
        Map<String,Object> map=new HashMap<>();
        int dataCount=rentalMapper.queryRentalDataCount();
        pageBean=new PageBean(pageBean.getNowPageIndex(),dataCount);
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Rental> rentalList=rentalMapper.queryAllRentalByGroup(map);
        pageBean.setList(rentalList);
        return pageBean;
    }

    @Override
    public void deleteRentalByRid(int rid) {
        rentalMapper.deleteByPrimaryKey(rid);
    }


}
