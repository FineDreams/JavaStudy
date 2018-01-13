package service;

import dao.UserDao;
import domain.User;

import java.util.List;

public class ShowService {
   private UserDao userDao=new UserDao();
    public List<User> searchByGroup(int begin,String uname,String gender,String score,String age){
        List<User> users = userDao.queryByGroup(begin, uname, gender, score, age);
        return users;
    }

    public int searchCount(String uname,String gender,String score,String age){
        int count = userDao.queryCount(uname, gender, score, age);
        return count;
    }

}
