package com.yy.crm.classes.dao;

import com.yy.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesDao {

    List<CrmClasses> findAll();
    CrmClasses queryClassById(String classId);

    void addOrEdit(CrmClasses crmClasses);

    CrmClasses findInfo(String classId);
}
