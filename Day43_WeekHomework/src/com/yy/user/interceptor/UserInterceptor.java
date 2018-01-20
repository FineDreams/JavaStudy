package com.yy.user.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

public class UserInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
        if (username==null){
            return "error";
        }
        return actionInvocation.invoke();
    }
}
