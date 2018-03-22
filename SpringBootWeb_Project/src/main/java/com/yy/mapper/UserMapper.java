package com.yy.mapper;

import com.yy.domain.User;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryByName(String username);

    User queryByPhone(String phone);


    User queryByLogin(Map<String, Object> map);

}