package com.yy.study;

import java.io.Serializable;

public class pet implements Serializable{
    private String name;
    private String gender;

    public pet(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "pet{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
