package com.yy.change;

public class Main {
     public static void main(String[] args) {
    	 //父类的引用指向了子类的对象
		 Film f1=new KongFu();
		 
//		 f1=new LieChang();
		 
		 
		 //父类的引用，只能找到父类的方法
		 //找不到子类独有的方法
		 f1.showFilm();
		 
		 if(f1 instanceof KongFu){
			 //如果f1这个引用指向的对象类型为KongFu
			 //那么我们可以进行强制类型转换
			 
			 //()中写的就是要强转的类型
			 KongFu LiZhou=(KongFu) f1;
			 LiZhou.start();
		 }
	}
}
