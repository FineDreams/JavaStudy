package com.yy.work;

public class UserNoneException extends LoginException {
			@Override
			public String getMessage() {
				return "用户名不存在!";
			}
}
