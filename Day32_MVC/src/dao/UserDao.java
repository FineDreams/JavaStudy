package dao;

import domain.User;

public class UserDao {
    public User queryByUsername(String username){
//        Class.forName("com.mysql.")

        if (username.equals("123")){
            User user=new User();
            user.setUsername("123");
            user.setPassword("666");
            return user;
        }else {
            return null;
        }

    }
}
