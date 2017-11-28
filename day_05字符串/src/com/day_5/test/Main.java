package com.day_5.test;

public class Main {
   public static void main(String[] args){
	   GayLun gl=new GayLun();
	   gl.setName("德玛西亚之力");
	   System.out.println("我的名字叫"+gl.getName());
       gl.setCamp("德玛西亚");
       System.out.println("我是"+gl.getCamp()+"阵营的");
       gl.setBlood(100);
       gl.putQ();
       gl.putW(gl.getBlood());
       System.out.println(gl.putR("R"));
       System.out.println();
	   
	   LiQing li=new LiQing();
	   li.seat("打野");
	   String say=li.saying();
	   System.out.println(say);
	   li.speaking();
	   System.out.println();
	   
	   YaSuo ys=new YaSuo();
	   ys.setName("疾风剑豪");
	   ys.Who(ys.getName());
       ys.putW();
	   System.out.println();
	   
	   MaiLin ml=new MaiLin();
	   ml.setName("麦林炮手");
	   ml.Name(ml.getName());
	   ml.setCamp("约德尔人");
	   System.out.println(ml.isCamp(ml.getCamp()));
	   System.out.println("特点是:"+ml.Feel());
	   
   }
}
