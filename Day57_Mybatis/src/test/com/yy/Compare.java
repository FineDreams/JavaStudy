package com.yy;

public class Compare {

    public static void main(String[] args) {
        Integer a=10;
        Integer b=100;

        Boolean f=false;
        Boolean t=true;


        System.out.println("比较整型");
        System.out.println(Integer.compare(a,a));
        System.out.println(Integer.compare(a,b));
        System.out.println(Integer.compare(b,a));

        System.out.println("比较布尔类型");

        System.out.println(Boolean.compare(f,f));
        System.out.println(Boolean.compare(f,t));
        System.out.println(Boolean.compare(t,f));

    }

}
