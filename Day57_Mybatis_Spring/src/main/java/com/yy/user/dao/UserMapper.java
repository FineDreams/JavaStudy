package com.yy.user.dao;
import com.yy.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
   User findUserById(int id);

   void insertUser(User user);
}
