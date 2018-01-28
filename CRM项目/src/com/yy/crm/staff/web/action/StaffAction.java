package com.yy.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.StaffService;
import com.yy.crm.staff.service.exception.LoginException;
import com.yy.crm.staff.service.exception.OldPasswordErrorException;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

public class StaffAction extends ActionSupport {
    private StaffService staffService;

    @Autowired
    private CrmStaff crmStaff;


    private String oldPassword;
    private String newPassword;
    private String reNewPassword;

    private String staffId;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

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

    public String logOut(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        CrmStaff crmStaff = (CrmStaff) session.getAttribute("crmStaff");
        if (crmStaff!=null){
            session.removeAttribute("crmStaff");
        }
        return "logOut";
    }

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

    public String queryAllInfo(){
        List<CrmDepartment> allInfoCrmStaffList = staffService.findAll();
        ActionContext.getContext().put("allInfoCrmStaffList",allInfoCrmStaffList);
        return "all";
    }

    public String queryInfoByStaffId(){

        CrmStaff infoByStaffId = staffService.findInfoByStaffId(staffId);

        ActionContext.getContext().put("crmStaff",infoByStaffId);
        return "edit";
    }

    public String editAll(){
        staffService.updateCrmStaff(crmStaff);
        return "editAll";
    }

    public String addStaff(){
        staffService.addCrmStaff(crmStaff);
        return "add";
    }

}
