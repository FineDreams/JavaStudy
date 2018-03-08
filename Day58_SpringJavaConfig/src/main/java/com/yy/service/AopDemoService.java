package com.yy.service;

import com.yy.anno.Action;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//表示这是一个service，也是Spring中的一个bean
@Service
public class AopDemoService {

    @Value("张三")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Action(name = "6666")
    public void showAop(){

    }
}
