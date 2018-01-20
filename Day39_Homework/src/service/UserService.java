package service;

import dao.UserDao;
import domain.User;
import service.exception.InsertFailedException;
import service.exception.InsertSuccess;
import service.exception.PasswordException;
import service.exception.UserNotException;

public class UserService {

    public void register(User fromTable){
        UserDao userDao=new UserDao();
        userDao.insertUser(fromTable);
    }

    public User searchByName(String name){
        UserDao userDao=new UserDao();
        User user = userDao.searchUser(name);
        return user;
    }

    public User login(User fromTable) throws UserNotException, PasswordException {
        UserDao userDao=new UserDao();
        User user = userDao.searchUser(fromTable.getUsername());
        if (user==null){
            throw new UserNotException();
        }
        if (!user.getPassword().equals(fromTable.getPassword())){
            throw new PasswordException();
        }
        return user;
    }

}
