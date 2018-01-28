package com.yy.factory;

import com.yy.createobj.User;

public class UserFactory extends AbstractFactory {
    @Override
    public User getInstance() {
        return new User("实例工厂创建的User",11,true);
    }
}
