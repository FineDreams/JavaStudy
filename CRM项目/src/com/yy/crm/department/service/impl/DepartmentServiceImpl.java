package com.yy.crm.department.service.impl;

import com.yy.crm.department.dao.DepartmentDao;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.department.service.DepartmentService;
import com.yy.crm.staff.domain.CrmStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentServiceImpl  implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public List<CrmDepartment> findAll() {
        List<CrmDepartment> allDepartment = departmentDao.findAll();
        return allDepartment;
    }

    @Override
    public CrmDepartment queryBydepId(String depId) {
        CrmDepartment crmDepartment=departmentDao.queryBydepId(depId);
        return crmDepartment;
    }

    @Override
    public void addOrEditDepartment(CrmDepartment crmDepartment) {
        departmentDao.addOrEditDepartment(crmDepartment);
    }

    @Override
    public List<CrmStaff> queryGroup(CrmStaff crmStaff) {
        StringBuilder sb=new StringBuilder("from CrmStaff cs where 1=1 ");
        String staffName = crmStaff.getStaffName();
        String postId = crmStaff.getCrmPost().getPostId();
        String depId = crmStaff.getCrmPost().getCrmDepartment().getDepId();
        if (!staffName.equals("")){
            sb.append(" and cs.staffName like'%"+staffName+"%'");
        }
        if (!postId.equals("")){
            sb.append(" and cs.crmPost.postId='"+postId+"'");
        }
        if (!depId.equals("")){
            sb.append(" and cs.crmPost.crmDepartment.depId='"+depId+"'");
        }
//        System.out.println(sb.toString()+"测试组合查询sql语句");
        List<CrmStaff> crmStaffList=departmentDao.queryGroup(sb.toString());
        return crmStaffList;
    }
}
