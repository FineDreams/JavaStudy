package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class OgnlAction extends ActionSupport implements ServletRequestAware{

    private String name="李小璐";

    public String getName() {
        return name;
    }

    private HttpServletRequest request;
    public String hello(){
        System.out.println("hello  struts2-tags");
        request.setAttribute("hello","哈啊啊哈哈哈哈嗝");
        return SUCCESS;
    }

    public String show(){
        ActionContext context = ActionContext.getContext();
        context.put("show","获得ActionContext中的值");
        return SUCCESS;
    }

    public String el(){
        ActionContext.getContext().put("name","PGOne");
        ActionContext.getContext().getSession().put("name","凉凉");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request=httpServletRequest;
    }
}
