package com.yy.service;

import com.yy.domain.Article;
import com.yy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

//    @Select("select * from basic_user where user_name=#{user_name}")
    User selectUserByName(String username);

//    @Select("insert into basic_user(user_name,phone,password) values(#{user_name},#{phone},#{password})")
    void insertUser(User user);

    User selectUserByPhone(String phone);

    User selectUserByLogin(String phone, String password);

    List<Article> selectAllArticle();

    Article queryByGoodId(int goodsId);

}
