package com.yy.crm.staff.service;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.exception.LoginException;
import com.yy.crm.staff.service.exception.OldPasswordErrorException;

import java.util.List;

public interface StaffService {
    CrmStaff findByName(CrmStaff crmStaff) throws LoginException;

    void updatePassword(String newPassword,String oldPassword,String loginName) throws OldPasswordErrorException;

    List<CrmDepartment> findAll();
    
    CrmStaff findInfoByStaffId(String staffId);

    void updateCrmStaff(CrmStaff crmStaff);

    void addCrmStaff(CrmStaff crmStaff);
}
