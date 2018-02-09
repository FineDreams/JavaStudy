package com.yy;

import com.yy.domain.User;

public class CompareTo {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        String s3="abcde";
        String s4="abcde";
        String s5="a2bc";

        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s2.compareTo(s4));
        System.out.println(s3.compareTo(s4));
        System.out.println(s4.compareTo(s5));


    }

}
