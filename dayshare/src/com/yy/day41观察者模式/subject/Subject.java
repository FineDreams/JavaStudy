package com.yy.day41观察者模式.subject;

import com.yy.day41观察者模式.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers=new ArrayList<>();

    //注册/添加 观察者
    public void add(Observer observer){
        //集合中的add
        observers.add(observer);
    }
    //删除观察者
    public void delete(Observer observer){
        //集合中的remove
        observers.remove(observer);
    }
    //通知
    public void notify(String message){
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
