package com.yy.Rtest;

public class test {
    public static void main(String[] args) {
      String str="345dfg";

        System.out.println(str.matches("[a-zA-Z]+[0-9]+|[0-9]+[a-zA-Z]+"));
    }
}
