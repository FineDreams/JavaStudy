package com.yy.math;

public class MiddleSearch {
    public static void main(String[] args){
    	int [] array={3,6,8,9,23,45,78};
    	Search s=new Search();
    	System.out.println("这个数的下标为:"+s.indexSearch(array, 9));
    }
}
class Search{
	public int indexSearch(int[] array,int a){
		int start=0;
		int end=array.length-1;
		int middle=(start+end)/2;
		while(a!=array[middle]){
			
			if(a<array[middle]){
				end=middle-1;
			}else if(a>array[middle]){
				start=middle+1;
			}
			middle=(start+end)/2;
		}
		return middle;
	}
}
