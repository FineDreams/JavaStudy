package com.yy.homework;

public class Person {
   private String name;
   private String job;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
   public void Work(){
	   System.out.println("人类会工作");
   }
   public void thinking(){
	   System.out.println("人类会思考");
   }
   
}
