package com.yy.study;

public class Main4 {
    public static void main(String[] args) {
        String str="abcdefg";
        System.out.println(Demo.stringReverse(str, 0, str.length() - 1));
    }
}
class Demo{
    public static String stringReverse(String string ,int node,int end){
        char[] chars = string.toCharArray();
        if (node<end){
            char temp=chars[node];
            chars[node]=chars[end];
            chars[end]=temp;
            node++;
            end--;
            string=stringReverse(String.valueOf(chars),node,end);
        }
        return string;
    }
}