package com.yy.crm.classes.service.impl;

import com.yy.crm.classes.dao.ClassesDao;
import com.yy.crm.classes.domain.CrmClasses;
import com.yy.crm.classes.service.ClassesService;

import java.util.List;

public class ClassesServiceImpl implements ClassesService{

    private ClassesDao classesDao;

    @Override
    public List<CrmClasses> findAll() {

        return classesDao.findAll();
    }

    @Override
    public CrmClasses queryClassById(String classId) {
        CrmClasses crmClasses = classesDao.queryClassById(classId);
        return crmClasses;
    }

    @Override
    public void addOrEdit(CrmClasses crmClasses) {
        classesDao.addOrEdit(crmClasses);
    }

    @Override
    public CrmClasses findInfo(String classId) {
        CrmClasses crmClasses=classesDao.findInfo(classId);
        return crmClasses;
    }


    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }
}
