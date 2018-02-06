package com.yy.crm.department.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.department.service.DepartmentService;

import java.util.List;

public class DepartmentAction extends ActionSupport implements ModelDriven{
    private DepartmentService departmentService;
    private CrmDepartment crmDepartment=new CrmDepartment();

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String queryAllDepartment(){
        List<CrmDepartment> all = departmentService.findAll();
        ActionContext.getContext().put("allDepartment",all);
        return "allDepartment";
    }

    //通过depId进入编辑页面
    public String queryBydepId(){
        CrmDepartment department=departmentService.queryBydepId(crmDepartment.getDepId());
        ActionContext.getContext().put("department",department);
        return "queryBydepId";
    }

    //添加和编辑部门
    public String addOrEditDepartment(){
        departmentService.addOrEditDepartment(crmDepartment);

        return "addOrEdit";
    }

    @Override
    public Object getModel() {
        return crmDepartment;
    }
}
