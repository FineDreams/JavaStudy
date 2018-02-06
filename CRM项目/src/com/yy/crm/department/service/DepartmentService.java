package com.yy.crm.department.service;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface DepartmentService {
    List<CrmDepartment> findAll();

    CrmDepartment queryBydepId(String depId);

    void addOrEditDepartment(CrmDepartment crmDepartment);

    List<CrmStaff> queryGroup(CrmStaff crmStaff);
}
