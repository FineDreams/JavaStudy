package com.yy.crm.department.dao;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface DepartmentDao {
    List<CrmDepartment> findAll();

    CrmDepartment queryBydepId(String depId);

    void addOrEditDepartment(CrmDepartment crmDepartment);

    List<CrmStaff> queryGroup(String sb);
}
