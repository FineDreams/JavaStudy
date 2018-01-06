package service;

import dao.UserDao;
import domain.User;
import service.exception.InvalidUsernameException;
import service.exception.LoginException;
import service.exception.PasswordNotMatchedException;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
public class UserService extends BaseServlet{
    private UserDao userDao=new UserDao();
    public User login(User user) throws LoginException {
        User fromDb = userDao.queryByUsername(user.getUsername());
        //判断用户名是否存在
        if (fromDb==null){
            throw new InvalidUsernameException();
        }
        //如果查出的用户名与输入的用户名不相同
        if (!fromDb.getPassword().equals(user.getPassword())){
            throw new PasswordNotMatchedException();
//            抛出密码不匹配异常
        }
        return fromDb;
    }
}
