package com.yy.day44注解与自定义注解;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Method a = Class.forName(B.class.getName()).getDeclaredMethod("a");
        MyAnnotation annotation = a.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.param1());
        System.out.println(annotation.param2());

    }
}
