package com.day_5.test;

public class MaiLin {
    private String name;
    private String camp;
    private String height;
    
    public void setName(String name){
    	this.name=name;
    }
    public String getName(){
    	return name;
    }
    public void setCamp(String camp){
    	this.camp=camp;
    }
    public String getCamp(){
    	return camp;
    }
    public void setHeight(String height){
    	this.height=height;
    }
    public String getHeight(){
    	return height;
    }
    
    public void speaking(){
    	System.out.println("好想射点什么");
    }
    public void Name(String name){
    	System.out.println("我的名字叫:"+name);
    }
    public String isCamp(String camp){
    	return "所属阵营:"+camp;
    }
    public String Feel(){
    	return "很萌很可爱";
    }
}
