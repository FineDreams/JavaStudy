package com.yy.crm.staff.service.impl;

import com.yy.crm.staff.dao.StaffDao;
import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;
import com.yy.crm.staff.service.StaffService;
import com.yy.crm.staff.service.exception.OldPasswordErrorException;
import com.yy.crm.staff.service.exception.PasswordErrorException;
import com.yy.crm.staff.service.exception.UserNoExitException;
import com.yy.crm.utils.md5_util.Md5Encryption;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }


    @Override
    public CrmStaff findByName(CrmStaff crmStaffFrom) throws UserNoExitException, PasswordErrorException {
        List<CrmStaff> crmStaffs = staffDao.findByName(crmStaffFrom.getLoginName());
        String byMd5 = Md5Encryption.EncoderByMd5(crmStaffFrom.getLoginPwd());
//        System.out.println(byMd5+"----service---");
//        for (CrmStaff crmStaff : crmStaffs) {
//            System.out.println(crmStaff.toString());
//        }
        if (crmStaffs.size()==0){
            throw new UserNoExitException();
        }
        for (CrmStaff crmStaff : crmStaffs) {

            if (!(crmStaff.getLoginPwd()).equals(byMd5)){
                throw new PasswordErrorException();
            }
            return crmStaff;
        }
        return null;
    }

    @Override
    public void updatePassword(String newPassword,String oldPassword,String loginName) throws OldPasswordErrorException {
        List<CrmStaff> staffList = staffDao.findByName(loginName);
        CrmStaff crmStaff = staffList.get(0);
        String encoderByMd5 = Md5Encryption.EncoderByMd5(oldPassword);
        String newByMd5 = Md5Encryption.EncoderByMd5(newPassword);
        String loginPwd = crmStaff.getLoginPwd();
        if (!encoderByMd5.equals(loginPwd)){
            throw new OldPasswordErrorException();
        }
        staffDao.updatePassword(newByMd5,loginName);
    }

    @Override
    public List<CrmDepartment> findAll() {
        List<CrmDepartment> allInfoCrmStaffList = staffDao.findAllCrmStaff();
        return allInfoCrmStaffList;
    }

    @Override
    public CrmStaff findInfoByStaffId(String staffId) {
        CrmStaff infoByStaffId = staffDao.findInfoByStaffId(staffId);
        return infoByStaffId;
    }

    @Override
    public void updateCrmStaff(CrmStaff crmStaff) {

        staffDao.updateCrmStaff(crmStaff);
    }

    @Override
    public void addCrmStaff(CrmStaff crmStaff) {
        staffDao.addStaff(crmStaff);
    }

    @Override
    public List<CrmStaff> findAllCrmStaff() {
       List<CrmStaff> crmStaffList=staffDao.queryAllCrmStaff();
        return crmStaffList;
    }
}
