package com.yy.work;

public class NmPdNoneException extends LoginException{
			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "用户名密码不匹配!";
			}
			
}
