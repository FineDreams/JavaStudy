package com.yy.crm.department.service.impl;

import com.yy.crm.department.dao.DepartmentDao;
import com.yy.crm.department.service.DepartmentService;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class DepartmentServiceImpl extends HibernateDaoSupport implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
