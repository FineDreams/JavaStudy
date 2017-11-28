package com.day_5.test;

public class GayLun {
   private String name;
   private int blood;
   private String camp;
   
   public void setName(String name){
	   this.name=name;
   }
   public String getName(){
	   return name;
   }
   public void setBlood(int blood){
	   this.blood=blood;
   }
   public int getBlood(){
	   return blood;
   }
   public void setCamp(String camp){
	   this.camp=camp;
   }
   public String getCamp(){
	   return camp;
   }
   
   public void putQ(){
	   System.out.println("请按Q技能");
   }
   public void putW(int blood){
	   System.out.println("我血量只有"+blood+"了");
   }
   public String putE(){
	   return "按住E技能向前进攻";
   }
   public String putR(String R){
	   return "是时候使用大招"+R+"了，制裁他们";
   }
}
