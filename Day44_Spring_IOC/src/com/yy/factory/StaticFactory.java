package com.yy.factory;

import com.yy.createobj.User;

public class StaticFactory {

    //静态工厂
    public static User getInstance(){
        return new User();
    }

}
