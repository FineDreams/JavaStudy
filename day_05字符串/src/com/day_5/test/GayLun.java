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
	   System.out.println("�밴Q����");
   }
   public void putW(int blood){
	   System.out.println("��Ѫ��ֻ��"+blood+"��");
   }
   public String putE(){
	   return "��סE������ǰ����";
   }
   public String putR(String R){
	   return "��ʱ��ʹ�ô���"+R+"�ˣ��Ʋ�����";
   }
}
