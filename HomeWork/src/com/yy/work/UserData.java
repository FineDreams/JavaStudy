package com.yy.work;

import java.util.ArrayList;
import java.util.List;

public class UserData {
		private static List<Person> list=new ArrayList<Person>();
		
		public static List getList() {
			return list;
		}

		public static void setList(List list) {
			UserData.list = list;
		}
	

}
