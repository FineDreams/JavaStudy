package com.yy.day41观察者模式.observer;

public class Reader  implements Observer{
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "---" + message);
    }
}
