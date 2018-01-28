package com.yy.crm.department.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yy.crm.department.service.DepartmentService;

public class DepartmentAction extends ActionSupport{
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
