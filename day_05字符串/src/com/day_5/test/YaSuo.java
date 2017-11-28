package com.day_5.test;

public class YaSuo {
    private String name;
    private String seat;
    private String fightSpeak;
    
    public void setName(String name){
    	this.name=name;
    }
    public String getName(){
    	return name;
    }
    public void setSeat(String seat){
    	this.seat=seat;
    }
    public String getSeat(){
    	return seat;
    }
    public void setFight(String fightSpeak){
    	this.fightSpeak=fightSpeak;
    }
    public String getFight(){
    	return fightSpeak;
    }
    
    public void putW(){
    	System.out.println("背对疾风吧");
    }
    public void Who(String name){
    	System.out.println("我就是:"+name+"一个孤独的剑客");
    }
    public String putR(){
    	return "我要放大招了";
    }
    public String showFight(String fightSpeak){
    	return fightSpeak;
    }
}
