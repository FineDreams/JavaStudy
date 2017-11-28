package com.day_5.test;

public class LiQing {
   private String name;
   private String jungle;
   private int fighting;
   
   public void setName(String name){
	   this.name=name;
   }
   public String getName(){
	   return name;
   }
   public void setjunGle(String jungle){
	   this.jungle=jungle;
   }
   public String getjunGle(){
	   return jungle;
   }
   public void setFighting(int fighting){
	   this.fighting=fighting;
   }
   public int getFighting(){
	   return fighting;
   }
   
   public void speaking(){
	   System.out.println("我用双手成就你的梦想");
   }
   public void seat(String jungle){
	   System.out.println("英雄定位:"+jungle);
   }
   public String saying(){
	   return "即使双目失明，也丝毫不影响我追捕敌人";
   }
   public int Fight(int fighting){
	   return fighting;
   }
}
