package com.yy.homwork2;

public class Main {
	static Contact[] array=new Contact[10];
   public static void main(String[] args){
	   
	   Contact p1=new Contact("��һ","1111");
	   p1.setGroup("����");
	   p1.setSex("��");
	   
	   Contact p2=new Contact("�Ŷ�","2222");
	   p2.setGroup("����");
	   p2.setSex("Ů");
	   
	   Contact p3=new Contact("����","3333");
	   p3.setGroup("����");
	   p3.setSex("��");
	   
	   Contact p4=new Contact("����","4444");
	   p4.setGroup("����");
	   p4.setSex("��");
	   
	   Contact p5=new Contact("����","5555");
	   p5.setGroup("����");
	   p5.setSex("��");
	   
	   Contact p6=new Contact("����","6666");
	   p6.setGroup("İ����");
	   p6.setSex("��");
	   
	   Contact p7=new Contact("С��","7777");
	   p7.setGroup("İ����");
	   p7.setSex("Ů");
	   
	   Contact p8=new Contact("����","8888");
	   p8.setGroup("ͬѧ");
	   p8.setSex("Ů");
	   
	   Contact p9=new Contact("�ں�","9999");
	   p9.setGroup("ͬѧ");
	   p9.setSex("��");
	   
	   Contact p10=new Contact("����","1234");
	   p10.setGroup("Ů����");
	   p10.setSex("Ů");
	   
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
	   System.out.println("���˷����µ���ϵ��Ϊ:");
	   showGroup("����");
	   
	   System.out.println();
	   System.out.println("������绰����������ϵ��:");
	   showTellPhone("1234");
	   
	   System.out.println();
	   System.out.println("�Ա�ΪŮ����ϵ��Ϊ:");
	   showSex("Ů");
	   
	   
   }
   public static void addContact(Contact[] array,Contact contact){
	   int root=0;
	  for(;root<10&&array[root]!=null;root++){
		  if(array[root].getTellphone().equals(contact.getTellphone())){
                  System.out.println("��ϵ���Ѵ���");			  
		  }
	  }
		  if(root>=10){
			  System.out.println("��ϵ������");
		  }else if(contact.getName()==null||contact.getTellphone()==null){
			  System.out.println("���ʧ��");
		  }else{
				  array[root]=contact;
				  System.out.println("��ӳɹ�");
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
