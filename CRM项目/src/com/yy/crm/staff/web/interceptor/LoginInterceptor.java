package com.yy.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yy.crm.staff.domain.CrmStaff;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        CrmStaff crmStaff = (CrmStaff) ServletActionContext.getRequest().getSession().getAttribute("crmStaff");
        if (crmStaff==null){
            Object action = actionInvocation.getAction();
            if (action instanceof ActionSupport){
                ActionSupport actionSupport = (ActionSupport) action;
                actionSupport.addFieldError("loginMsg","登录后才能访问其他页面");
            }
            return "loginError";
        }

        return actionInvocation.invoke();
    }
}
