package com.yy.crm.staff.dao.impl;

import com.yy.crm.staff.dao.StaffDao;
import com.yy.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

//private CrmStaff crmStaff;
//
//    public void setCrmStaff(CrmStaff crmStaff) {
//        this.crmStaff = crmStaff;
//    }

    @Override
    public void add(CrmStaff crmStaff) {
        System.out.println("插入成功!");
//        this.getHibernateTemplate().setCheckWriteOperations(false);
        crmStaff.setStaffId(2);
        System.out.println(crmStaff);
        this.getHibernateTemplate().save(crmStaff);
    }
}
