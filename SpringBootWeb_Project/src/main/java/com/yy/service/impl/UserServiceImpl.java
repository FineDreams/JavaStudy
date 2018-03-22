package com.yy.service.impl;

import com.yy.domain.Article;
import com.yy.domain.User;
import com.yy.mapper.ArticleMapper;
import com.yy.mapper.UserMapper;
import com.yy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public User selectUserByName(String username) {
        User user=userMapper.queryByName(username);
        return user;
    }

    @Override
    public void insertUser(User user) {
        User userFromDB = userMapper.queryByName(user.getUserName());
        if (userFromDB==null){
            userMapper.insertSelective(user);
        }
    }

    @Override
    public User selectUserByPhone(String phone) {
        User user=userMapper.queryByPhone(phone);
        return user;
    }

    @Override
    public User selectUserByLogin(String phone, String password) {
        Map<String,Object> map=new HashMap<>();
        map.put("phone",phone);
        map.put("password",password);
        User user=userMapper.queryByLogin(map);
        return user;
    }

    @Override
    public List<Article> selectAllArticle() {
        List<Article> articles=articleMapper.queryAllArticle();
        return articles;
    }

    @Override
    public Article queryByGoodId(int goodsId) {
        Article article=articleMapper.queryArticlById(goodsId);
        return article;
    }

}
