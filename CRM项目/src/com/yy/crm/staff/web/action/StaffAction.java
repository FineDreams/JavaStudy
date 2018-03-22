package com.yy.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.department.service.DepartmentService;
import com.yy.crm.department.service.impl.DepartmentServiceImpl;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.StaffService;
import com.yy.crm.staff.service.exception.LoginException;
import com.yy.crm.staff.service.exception.OldPasswordErrorException;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

public class StaffAction extends ActionSupport implements ModelDriven{
    private StaffService staffService;
    @Autowired
    private CrmStaff crmStaff;

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private String oldPassword;
    private String newPassword;
    private String reNewPassword;


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    public CrmStaff getCrmStaff() {
        return crmStaff;
    }

    public StaffService getStaffService() {

        return staffService;
    }
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    //进入登录页面
    public String toLogin(){
        return "toLogin";
    }

    //登录
    public String login(){
        CrmStaff crmStaffFromDB;
        try {
             crmStaffFromDB= staffService.findByName(crmStaff);
        } catch (LoginException e) {
            addFieldError("loginMsg",e.getMessage());
            return "loginError";
        }
        ServletActionContext.getRequest().getSession().setAttribute("crmStaff",crmStaffFromDB);
        return "login";
    }
//重新登录
    public String logOut(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        CrmStaff crmStaff = (CrmStaff) session.getAttribute("crmStaff");
        if (crmStaff!=null){
            session.removeAttribute("crmStaff");
        }
        return "logOut";
    }
//编辑密码
    public String editPassword(){
        CrmStaff staff = (CrmStaff) ServletActionContext.getRequest().getSession().getAttribute("crmStaff");
        if (!newPassword.equals(reNewPassword)){
            addFieldError("updatePasswordMsg","两次输入密码不一致!");
            return "updateError";
        }
        try {
            staffService.updatePassword(newPassword,oldPassword,staff.getLoginName());
        } catch (OldPasswordErrorException e) {
            addFieldError("updatePasswordMsg",e.getMessage());
            return "updateError";
        }
        return "update";
    }
//查找所有员工
    public String queryAllInfo(){
        List<CrmDepartment> allInfoCrmStaffList = staffService.findAll();

        List<CrmStaff> crmStaffList=staffService.findAllCrmStaff();
        ActionContext.getContext().put("crmStaffList",crmStaffList);
        ActionContext.getContext().getValueStack().set("allInfoCrmStaffList",allInfoCrmStaffList);
        return "all";
    }
//通过id查找员工，进入编辑页面
    public String queryInfoByStaffId(){
        List<CrmDepartment> allDepartment = departmentService.findAll();
        CrmStaff infoByStaffId = staffService.findInfoByStaffId(crmStaff.getStaffId());

        ActionContext.getContext().put("crmStaff",infoByStaffId);
        ActionContext.getContext().getValueStack().set("allDepartment",allDepartment);
        return "edit";
    }
//编辑员工信息
    public String editAll(){
        staffService.updateCrmStaff(crmStaff);
        return "editAll";
    }
    //select标签中list集合元素

    public String getList(){
        List<CrmDepartment> allInfoCrmStaffList = staffService.findAll();
        ActionContext.getContext().getValueStack().set("allInfoCrmStaffList",allInfoCrmStaffList);
        return "list";
    }




//添加员工
    public String addStaff(){
        staffService.addCrmStaff(crmStaff);
        return "add";
    }
    //多条件组合查询
    public String queryGroup(){
        List<CrmStaff> crmStaffs=departmentService.queryGroup(crmStaff);
        List<CrmDepartment> allInfoCrmStaffList = staffService.findAll();
        ActionContext.getContext().getValueStack().set("allInfoCrmStaffList",allInfoCrmStaffList);
        ActionContext.getContext().put("crmStaffList",crmStaffs);
        return "queryGroup";
    }


    @Override
    public Object getModel() {
        return crmStaff;
    }
}
