package com.ty.user.service.impl;

import com.ty.user.dao.RentalMapper;
import com.ty.user.dao.UserMapper;
import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.user.service.UserService;
import com.ty.user.service.util.RentalPageBean;
import com.ty.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RentalMapper rentalMapper;

    @Override
    public User queryUserByName(String username) {
        User user=userMapper.selectUserByName(username);
        return user;
    }

    @Override
    public RentalPageBean queryAllRental(RentalPageBean pageBean) {
        Map<String,Object> map=new HashMap<>();
        if (pageBean.getPlace()!=null){
            map.put("place",pageBean.getPlace());
        }
        if (pageBean.getType()!=null){
            map.put("type",pageBean.getType());
        }
        int dataCount=rentalMapper.queryRentalCount(map);

        RentalPageBean rentalPageBean=new RentalPageBean(pageBean.getNowPageIndex(),dataCount);

        map.put("start",rentalPageBean.getStart());
        map.put("pageSize",rentalPageBean.getPageSize());

        rentalPageBean.setPlace(pageBean.getPlace());
        rentalPageBean.setType(pageBean.getType());
        List<Rental> rentalList=rentalMapper.queryAllRentalByGroup(map);
        rentalPageBean.setList(rentalList);
        return rentalPageBean;
    }

    @Override
    public void addRental(Rental rental) {
        rental.setState("2");
        rentalMapper.insertSelective(rental);
    }

    @Override
    public Rental queryRentalByRid(int rid) {
        Rental rental=rentalMapper.selectByPrimaryKey(rid);
        return rental;
    }

    @Override
    public void rentalModify(Rental rental) {
        rentalMapper.updateByPrimaryKeySelective(rental);
    }

    @Override
    public PageBean queryRentalByUid(int uid,int nowPageIndex) {
        int dataCount=rentalMapper.selectDataCountByUid(uid);
        Map<String,Object> map=new HashMap<>();
        System.out.println("数据条数:"+dataCount);
        PageBean pageBean=new PageBean(nowPageIndex,dataCount);
        map.put("uid",uid);
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Rental> rentalList= rentalMapper.queryRentalByUid(map);
        pageBean.setList(rentalList);
        return pageBean;
    }

    @Override
    public void changeState(int rid) {
        Rental rental = rentalMapper.selectByPrimaryKey(rid);
        if (rental.getState().equals("2")){
            rental.setState("1");
            rentalMapper.updateByPrimaryKeySelective(rental);
        }
    }

    @Override
    public void modifyUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserById(int uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public void modifyUserPassword(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


}
