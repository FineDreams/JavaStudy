package com.yy.homwork2;

public class Contact {
    private String name;
    private String sex;
    private String tellphone;
    private String address;
    private String group;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
    
	public Contact(String name,String tellphone){
		this.name=name;
		this.tellphone=tellphone;
	}
	public String showContact(){
		return "姓名:"+name+" 性别:"+sex+" 电话号码:"+
	       tellphone+" 住址:"+address+" 所属分组:"+group;
	}
    
}
