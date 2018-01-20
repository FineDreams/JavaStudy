package com.yy.观察者模式作业.subject;

import com.yy.观察者模式作业.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Book extends Subject {
    private String name;
    private List<Observer> observers=new ArrayList<>();

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String info) {
        for (Observer observer : observers) {
            observer.update(name+"---"+info);
        }
    }
}
