package com.yy.crm.department.dao.impl;

import com.yy.crm.department.dao.DepartmentDao;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    @Override
    public List<CrmDepartment> findAll() {
        List<CrmDepartment> allDepartment = (List<CrmDepartment>) this.getHibernateTemplate().find("from CrmDepartment ");
        return allDepartment;
    }

    @Override
    public CrmDepartment queryBydepId(String depId) {
        CrmDepartment crmDepartment = getHibernateTemplate().get(CrmDepartment.class, depId);
        return crmDepartment;
    }

    @Override
    public void addOrEditDepartment(CrmDepartment crmDepartment) {
        String depId = crmDepartment.getDepId();
        if (!depId.equals("")){
            CrmDepartment department = getHibernateTemplate().get(CrmDepartment.class, depId);
            department.setDepName(crmDepartment.getDepName());
        }else {
            getHibernateTemplate().save(crmDepartment);
        }

    }

    @Override
    public List<CrmStaff> queryGroup(String sb) {
        List<CrmStaff> crmStaffList= (List<CrmStaff>) this.getHibernateTemplate().find(sb);
        return crmStaffList;
    }
}
