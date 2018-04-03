package com.ty.user.service;

import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.user.service.util.RentalPageBean;
import com.ty.util.PageBean;

import java.util.List;

public interface UserService {
    User queryUserByName(String username);

    RentalPageBean queryAllRental(RentalPageBean rentalPageBean);

    void addRental(Rental rental);

    Rental queryRentalByRid(int rid);

    void rentalModify(Rental rental);

    PageBean queryRentalByUid(int uid,int nowPageIndex);

    void changeState(int rid);

    void modifyUserInfo(User user);

    User selectUserById(int uid);

    void modifyUserPassword(User user);
}
