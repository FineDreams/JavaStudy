package com.yy.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//一般就是不知道这个类有什么具体的作用时就用这个注解
@Component("p")
public class Person {

    @Qualifier("car1")
    @Autowired
    private Car car;


    @Value("王二麻字")
    private String name;

    private String gender;

    public String getGender() {
        return gender;
    }

    //表示必须有值的
    @Value("阴阳")
    @Required
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                "gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
    @PostConstruct
    public void showPost(){
        System.out.println("初始化了-------");
    }

    @PreDestroy
    public void showPre(){
        System.out.println("销毁了-----");
    }
}
