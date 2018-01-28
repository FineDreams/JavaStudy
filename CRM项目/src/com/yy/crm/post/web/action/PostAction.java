package com.yy.crm.post.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.post.service.PostService;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PostAction {
    private PostService postService;

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    private String depId;

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String ajaxPosition(){
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(depId+"---测试depId");
        List<CrmPost> crmPosts = postService.ajaxGet(depId);
        System.out.println(crmPosts.toString()+"测试json");
        JSONArray jsonArray=JSONArray.fromObject(crmPosts);
        System.out.println(jsonArray.toString()+"-----json");
        ActionContext.getContext().put("jsonArray",jsonArray);
        return "json";
    }
}
