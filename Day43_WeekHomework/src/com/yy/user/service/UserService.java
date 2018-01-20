package com.yy.user.service;

import com.yy.user.dao.UserDao;
import com.yy.user.domain.User;
import com.yy.user.service.exception.PassWordErrorException;
import com.yy.user.service.exception.UserNameNoneException;

import java.util.List;

public class UserService {
   private UserDao userDao=new UserDao();
    public User searchByUname(User user) throws UserNameNoneException, PassWordErrorException {
        List<User> users = userDao.queryByUsername(user.getUsername());
        if (users.size()==0){
            throw new UserNameNoneException();
        }
        for (User user1 : users) {
            if (!(user1.getPassword()).equals(user.getPassword())){
                throw new PassWordErrorException();
            }
            return user1;
        }
        return null;
    }
}
