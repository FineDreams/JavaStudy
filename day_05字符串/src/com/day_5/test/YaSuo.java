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
    	System.out.println("���Լ����");
    }
    public void Who(String name){
    	System.out.println("�Ҿ���:"+name+"һ���¶��Ľ���");
    }
    public String putR(){
    	return "��Ҫ�Ŵ�����";
    }
    public String showFight(String fightSpeak){
    	return fightSpeak;
    }
}
