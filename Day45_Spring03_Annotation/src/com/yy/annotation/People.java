package com.yy.annotation;

public class People {

    private String name;


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
