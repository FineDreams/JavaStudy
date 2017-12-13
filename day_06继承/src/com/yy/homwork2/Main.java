package com.yy.homwork2;

public class Main {
	static Contact[] array=new Contact[10];
   public static void main(String[] args){
	   
	   Contact p1=new Contact("张一","1111");
	   p1.setGroup("家人");
	   p1.setSex("男");
	   
	   Contact p2=new Contact("张二","2222");
	   p2.setGroup("家人");
	   p2.setSex("女");
	   
	   Contact p3=new Contact("张三","3333");
	   p3.setGroup("家人");
	   p3.setSex("男");
	   
	   Contact p4=new Contact("李四","4444");
	   p4.setGroup("朋友");
	   p4.setSex("男");
	   
	   Contact p5=new Contact("王五","5555");
	   p5.setGroup("朋友");
	   p5.setSex("男");
	   
	   Contact p6=new Contact("老王","6666");
	   p6.setGroup("陌生人");
	   p6.setSex("男");
	   
	   Contact p7=new Contact("小龙","7777");
	   p7.setGroup("陌生人");
	   p7.setSex("女");
	   
	   Contact p8=new Contact("西西","8888");
	   p8.setGroup("同学");
	   p8.setSex("女");
	   
	   Contact p9=new Contact("黑黑","9999");
	   p9.setGroup("同学");
	   p9.setSex("男");
	   
	   Contact p10=new Contact("琪琪","1234");
	   p10.setGroup("女朋友");
	   p10.setSex("女");
	   
	   Contact p11=new Contact("fsdf","234324");

	   addContact(array,p1);
	   addContact(array,p2);
	   addContact(array,p3);
	   addContact(array,p4);
	   addContact(array,p5);
	   addContact(array,p6);
	   addContact(array,p7);
	   addContact(array,p8);
	   addContact(array,p9);
	   addContact(array,p10);
	   addContact(array,p11);
	   showInformation(array);
	   
	   System.out.println();
	   System.out.println("家人分组下的联系人为:");
	   showGroup("家人");
	   
	   System.out.println();
	   System.out.println("请输入电话号码搜索联系人:");
	   showTellPhone("1234");
	   
	   System.out.println();
	   System.out.println("性别为女的联系人为:");
	   showSex("女");
	   
	   
   }
   public static void addContact(Contact[] array,Contact contact){
	   int root=0;
	  for(;root<10&&array[root]!=null;root++){
		  if(array[root].getTellphone().equals(contact.getTellphone())){
                  System.out.println("联系人已存在");			  
		  }
	  }
		  if(root>=10){
			  System.out.println("联系人已满");
		  }else if(contact.getName()==null||contact.getTellphone()==null){
			  System.out.println("添加失败");
		  }else{
				  array[root]=contact;
				  System.out.println("添加成功");
		  }
	  
   }
   public static void showInformation(Contact[] array){
	   for(int i=0;i<10;i++){
		   if(array[i]!=null){
			   System.out.println(array[i].showContact());
		   }
	   }
   }
   public static void showGroup(String group){
	   for(int i=0;i<10;i++){
		   if(array[i]!=null&&group.equals(array[i].getGroup())){
			   System.out.println(array[i].showContact());
		   }
	   }
   }
   public static void showTellPhone(String tellphone){
	   for(int i=0;i<10;i++){
		   if(array[i]!=null&&tellphone.equals(array[i].getTellphone())){
			   System.out.println(array[i].showContact());
		   }
	   }
   }
   public static void showSex(String sex){
	   for(int i=0;i<10;i++){
		   if(array[i]!=null&&sex.equals(array[i].getSex())){
			   System.out.println(array[i].showContact());
		   }
	   }
   }
}
