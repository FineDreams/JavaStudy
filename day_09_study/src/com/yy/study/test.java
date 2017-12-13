package com.yy.study;

public class test {
    public static void main(String[] args) {
        int[] array=new int[]{4,5,6,12,13,19,28,34,45,46,47};
        System.out.println(middleSearch.middleSch(array,46));
    }
}
class middleSearch{
    public static int middleSch(int[] array,int a){
        int start=0;
        int end=array.length-1;
        int middle=(start+end)/2;
        while(a!=array[middle]){
            if(a<array[middle]){
                end=middle-1;
            }if (a>array[middle]){
                start=middle+1;
            }
            middle=(start+end)/2;
        }
        return middle;
    }
}

