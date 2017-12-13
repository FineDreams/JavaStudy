package com.yy.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class UserData {
	private static List list=new ArrayList();

	public static   void setList(List list){
		UserData.list=list;
	}
	public static List getList(){
		return list;
	}

}
