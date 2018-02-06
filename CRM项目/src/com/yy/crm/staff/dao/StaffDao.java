package com.yy.crm.staff.dao;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffDao {
    List<CrmStaff> findByName(String username);

    void updatePassword(String newPassword,String loginName);

    List<CrmDepartment> findAllCrmStaff();

    CrmStaff findInfoByStaffId(String staffId);

    void updateCrmStaff(CrmStaff crmStaff);


    void addStaff(CrmStaff crmStaff);

    List<CrmStaff> queryAllCrmStaff();

}
