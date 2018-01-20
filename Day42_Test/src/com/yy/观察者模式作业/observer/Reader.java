package com.yy.观察者模式作业.observer;


public class Reader implements Observer {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String info) {
        System.out.println(name + "---" + info);
    }

}
