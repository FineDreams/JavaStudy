package com.day_5.test;

public class Main {
   public static void main(String[] args){
	   GayLun gl=new GayLun();
	   gl.setName("��������֮��");
	   System.out.println("�ҵ����ֽ�"+gl.getName());
       gl.setCamp("��������");
       System.out.println("����"+gl.getCamp()+"��Ӫ��");
       gl.setBlood(100);
       gl.putQ();
       gl.putW(gl.getBlood());
       System.out.println(gl.putR("R"));
       System.out.println();
	   
	   LiQing li=new LiQing();
	   li.seat("��Ұ");
	   String say=li.saying();
	   System.out.println(say);
	   li.speaking();
	   System.out.println();
	   
	   YaSuo ys=new YaSuo();
	   ys.setName("���罣��");
	   ys.Who(ys.getName());
       ys.putW();
	   System.out.println();
	   
	   MaiLin ml=new MaiLin();
	   ml.setName("��������");
	   ml.Name(ml.getName());
	   ml.setCamp("Լ�¶���");
	   System.out.println(ml.isCamp(ml.getCamp()));
	   System.out.println("�ص���:"+ml.Feel());
	   
   }
}
