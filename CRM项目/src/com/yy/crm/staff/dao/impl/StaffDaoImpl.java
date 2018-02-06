package com.yy.crm.staff.dao.impl;

import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.staff.dao.StaffDao;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    private CrmStaff crmStaff;

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    @Override
    public List<CrmStaff> findByName(String username) {
        List<CrmStaff> crmStaffs = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff c where c.loginName=?",username);
        return crmStaffs;
    }

    @Override
    public void updatePassword(String newPassword,String loginName) {
        List<CrmStaff> staffList = findByName(loginName);
        CrmStaff crmStaff = staffList.get(0);
        crmStaff.setLoginPwd(newPassword);
    }

    @Override
    public List<CrmDepartment> findAllCrmStaff() {
        List<CrmDepartment> from_crmDepartment_ = (List<CrmDepartment>) this.getHibernateTemplate().find("from CrmDepartment ");
        return from_crmDepartment_;
    }

    @Override
    public CrmStaff findInfoByStaffId(String staffId) {
        List<CrmStaff> list = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff where staffId=?", staffId);
        return list.get(0);
    }

    @Override
    public void updateCrmStaff(CrmStaff crmStaff) {
        CrmPost crmPost = this.getHibernateTemplate().get(CrmPost.class, crmStaff.getCrmPost().getPostId());
        crmStaff.setCrmPost(crmPost);
        this.getHibernateTemplate().update(crmStaff);
    }

    @Override
    public void addStaff(CrmStaff crmStaff) {
        CrmPost crmPost = getHibernateTemplate().get(CrmPost.class, crmStaff.getCrmPost().getPostId());
        CrmDepartment crmDepartment = getHibernateTemplate().get(CrmDepartment.class, crmPost.getCrmDepartment().getDepId());
        crmPost.setCrmDepartment(crmDepartment);
        crmStaff.setCrmPost(crmPost);
        this.getHibernateTemplate().save(crmStaff);
    }

    @Override
    public List<CrmStaff> queryAllCrmStaff() {
        List<CrmStaff> crmStaffList= (List<CrmStaff>) getHibernateTemplate().find("from CrmStaff ");
        return crmStaffList;
    }
}
