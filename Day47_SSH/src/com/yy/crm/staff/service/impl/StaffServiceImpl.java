package com.yy.crm.staff.service.impl;

import com.yy.crm.staff.dao.StaffDao;
import com.yy.crm.staff.dao.impl.StaffDaoImpl;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.StaffService;
import org.springframework.stereotype.Component;

public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public void add(CrmStaff crmStaff) {
        staffDao.add(crmStaff);
    }
}
