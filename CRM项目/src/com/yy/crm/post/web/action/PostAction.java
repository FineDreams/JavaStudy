package com.yy.crm.post.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.department.service.DepartmentService;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.post.service.PostService;
import com.yy.crm.staff.domain.CrmStaff;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost>{
    private PostService postService;
    private CrmPost crmPost=new CrmPost();

    private DepartmentService departmentService;

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    public PostService getPostService() {
        return postService;
    }

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

    public String ajaxPosition() throws IOException {
//        System.out.println(crmPost.getCrmDepartment().getDepName()+"==测试depName");
        List<CrmPost> crmPosts = postService.ajaxGet(crmPost.getCrmDepartment());
//        System.out.println(crmPosts.toString()+"测试json");
        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.setExcludes(new String[]{"crmDepartment","crmStaffs"});

        String jsonData = JSONArray.fromObject(crmPosts, jsonConfig).toString();

        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");

        ServletActionContext.getResponse().getWriter().print(jsonData);
        return NONE;
    }
//高级查询，组合查询
    public String searchGroup(){
        return "searchGroup";
    }

    //
    public String queryAllDep(){
        List<CrmPost> crmPosts=postService.queryAllDep();
        ActionContext.getContext().put("crmPosts",crmPosts);
        return "allDep";
    }

    //编辑职务按钮
    public String editPost(){
        CrmPost post=postService.queryByPostId(crmPost.getPostId());
        ActionContext.getContext().put("crmPost",post);
        List<CrmDepartment> allDepartment = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("allDepartment",allDepartment);
        return "editPost";
    }

    public String queryAllDepartment(){
        List<CrmDepartment> all = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("allDepartment",all);
        return "allDepartment";
    }

    //添加或者删除
    public String addOrEditPost(){
        postService.addOrEdit(crmPost);
        return "addOrEdit";
    }






    @Override
    public CrmPost getModel() {
        return crmPost;
    }



}
