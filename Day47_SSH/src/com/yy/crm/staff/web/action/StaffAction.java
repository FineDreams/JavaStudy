package com.yy.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.StaffService;

public class StaffAction extends ActionSupport{

    private CrmStaff crmStaff;

    public CrmStaff getCrmStaff() {
        return crmStaff;
    }

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    private StaffService staffService;

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public String register(){
        staffService.add(crmStaff);
        ActionContext.getContext().put("crmStaff",crmStaff);
        return SUCCESS;
    }
}
