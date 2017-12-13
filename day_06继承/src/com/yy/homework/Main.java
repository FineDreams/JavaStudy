package com.yy.homework;

public class Main {
   public static void main(String[] args){
	   Teacher t=new Teacher();
	   t.setJob("教书育人");
	   t.setHobby("教书");
	   t.setName("辛勤的园丁");
	   t.thinking();
	   t.teach();
	   
	   Worker worker=new Worker();
	   worker.setJob("劳动");
	   worker.setName("工人");
	   worker.setWages(3000);
	   worker.Work();
	   worker.Working();
   }
}
