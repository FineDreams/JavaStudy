package com.ty.user.dao;

import com.ty.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByName(String username);

    List<User> selectAllUser();

    int queryDataCount();

    List<User> queryUserGroup(Map<String, Object> map);

}