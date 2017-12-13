package com.yy.work;

public class UserNameExistsException extends RegisterException{
			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "用户名已存在!";
			}
}
