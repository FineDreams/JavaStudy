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
	   System.out.println("����˫�ֳɾ��������");
   }
   public void seat(String jungle){
	   System.out.println("Ӣ�۶�λ:"+jungle);
   }
   public String saying(){
	   return "��ʹ˫Ŀʧ����Ҳ˿����Ӱ����׷������";
   }
   public int Fight(int fighting){
	   return fighting;
   }
}
