package com.yy.study;

import com.yy.study.componet.可乐Component;
import com.yy.study.decorator.兑水Decorator;
import com.yy.study.decorator.加醋Derorator;

public class Main {
    public static void main(String[] args) {

        //来杯可乐
        可乐Component 可乐=new 可乐Component();

        //兑点水
        兑水Decorator 兑水=new 兑水Decorator(可乐);
        加醋Derorator 加醋=new 加醋Derorator(兑水);
        System.out.println(加醋.getName()+"---"+加醋.price());
    }
}
