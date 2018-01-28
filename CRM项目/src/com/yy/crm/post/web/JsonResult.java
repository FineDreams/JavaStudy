package com.yy.crm.post.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

public class JsonResult implements Result{
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        JSONArray jsonArray = (JSONArray) ActionContext.getContext().get("jsonArray");
        ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
    }
}
