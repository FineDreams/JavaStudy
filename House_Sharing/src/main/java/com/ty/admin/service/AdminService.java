package com.ty.admin.service;

import com.ty.admin.domain.Admin;
import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.util.PageBean;

import java.util.List;

public interface AdminService {
    Admin queryAdminByName(String adminCode);

    PageBean queryAllUser(PageBean pageBean);

    void deleteUserById(int uid);


    PageBean queryAllRental(PageBean pageBean);

    void deleteRentalByRid(int rid);

}
