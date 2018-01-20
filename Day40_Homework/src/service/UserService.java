package service;

import dao.UserDao;
import domain.User;

public class UserService {
    private UserDao userDao=new UserDao();
    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public User searchByUserName(String username){
        User user = userDao.searchUser(username);
        return user;
    }
}
